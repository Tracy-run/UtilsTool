package redis.myclient;

import redis.myconnection.MyConnection;
import redis.myprotocol.MyProtocol;

public class MyClient {

	
	private static MyConnection connection;
	
	public MyClient(String host,int port){
		connection = new MyConnection(host, port);
	}
	
	public static String get(String key){
		connection.sendCommand(MyProtocol.Command.GET, key.getBytes());
		return connection.getReplayCode();
	}
	
	public static String set(String key,String value){
		connection.sendCommand(MyProtocol.Command.SET, key.getBytes(),value.getBytes());
		return connection.getReplayCode();
	}
	
}
