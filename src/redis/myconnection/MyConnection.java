package redis.myconnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import redis.myprotocol.MyProtocol;

public class MyConnection {

	private Socket socket;
	private String host;
	private int port;
	
	private OutputStream outputStream;
	private InputStream inputStream;
	
	public MyConnection(String host,int port){
		this.host = host;
		this.port = port;
		getConnection(host, port);
	}
	
	public void getConnection(String host,int port){
		try {
			this.socket = new Socket(host, port);
			this.outputStream = socket.getOutputStream();
			this.inputStream = socket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void sendCommand(MyProtocol.Command command,byte[] ... args){
		MyProtocol.sendCommand(this.outputStream, command, args);
	}
	
	
	public String getReplayCode(){
		byte [] bytes = new byte[1024];
		try {
//			inputStream = socket.getInputStream();
			this.inputStream.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bytes);
	}
	
}
