package netty.demo.client;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

public class DemoClient {
	
	public static void main(String[] args) {
		
		ClientBootstrap clientBootstrap = new ClientBootstrap();
		
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		clientBootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));
		
		clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipline = Channels.pipeline();
				pipline.addLast("decoder", new StringDecoder());
				pipline.addLast("encoder", new StringEncoder());
				pipline.addLast("hiHandler", new HiHandler());
				return pipline;
			}
		});
		
		ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1",10101));
		Channel channel = connect.getChannel();
		
		System.out.println("clinet start!");
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("please enter in ");
			channel.write(scanner.next());
		}
	}
}
