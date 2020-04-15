package cn.piao888.threadmq;

import cn.piao888.threadmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String QUEUE_NAME = "sys.mult.text.queue";

    public static void main(String[] argv) throws Exception {
        ConnectionUtil connectionUtil=new ConnectionUtil();
        // 获取到连接以及mq通道
        Connection connection = connectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        String message = "Hello World!";
        while(true){
            Thread.sleep(1000);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        //关闭通道和连接
        /*channel.close();
        connection.close();*/
    }
}
