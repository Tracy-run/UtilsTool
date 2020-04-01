package redis;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.myclient.MyClient;

public class MainClass {

	
	
	public static void main(String[] args) {
//		Jedis jedis = new Jedis("127.0.0.1", 6379);
//		System.out.println(jedis.set("11", "vlaue"));
//		System.out.println(jedis.get("11"));
		
		
		MyClient client = new MyClient("127.0.0.1", 6379);
		System.out.println(client.set("111", "11vlaue"));
		System.out.println(client.get("111"));
		
	}
	
}
