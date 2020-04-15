package cn.piao888.threadmq.utils.threadutils;

import java.io.IOException;

import cn.piao888.threadmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;
import com.rabbitmq.tools.json.JSONUtil;


public class Recv {

    private final static String QUEUE_NAME = "sys.mult.text.queue";

    /**
     * 通过监听的方式 接收消息
     *
     * @throws Exception
     */
    public void newMethod() throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 消息堵塞在这
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            //当收到消息后 触发这个功能
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println(Thread.currentThread().getName()+ ": " + msg);
            }

        };
        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
	public static void oldMethod() throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 定义队列的消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);

		// 监听队列
		channel.basicConsume(QUEUE_NAME, true, consumer);

		// 获取消息
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(HandlerDataSource.getDataSource() + ": " + message + "'");
		}
	}
}
