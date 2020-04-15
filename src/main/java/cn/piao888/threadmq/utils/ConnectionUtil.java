package cn.piao888.threadmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception{
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("47.104.92.214");
//		factory.setHost("192.168.0.106");
		//端口
		factory.setPort(5672);
		factory.setUsername("BigRich");
		factory.setPassword("123");
//		factory.setUsername("sdgc");
//		factory.setPassword("sdgc1975");
		factory.setVirtualHost("/");
		//通过工程获取连接
		Connection connection=factory.newConnection();
		return connection;
	}

}
