package socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	final static String ADDRESS = "127.0.0.1";
	final static int PORT = 8765;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			socket = new Socket(ADDRESS, PORT);
			// 接受服务端发来的信息
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 向服务端发送数据
			out = new PrintWriter(socket.getOutputStream(), true); 
			
			// 向服务器端发送数据
			out.println("接收到客户端的请求数据...");
			out.println("接收到客户端的请求数据1111...");
			// 客户端接收到的数据
			String response = in.readLine();
			System.out.println("Client: " + response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			socket = null;
		}
	}
}
