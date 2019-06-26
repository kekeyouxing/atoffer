package atoffer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test implements Runnable{

	boolean stopped = false;
	private ServerSocket server;
	public void run() {
		//while(stopped) {
			
			try {
				
				Socket socket = server.accept();
				System.out.println("创建成功");
			} catch (IOException e) {
				System.out.println("test IO");
				
				//e.printStackTrace();
			}catch(NullPointerException nulle) {
				System.out.println("server is null caused");
			}
			
		//}
	}
	public ServerSocket initialize() throws UnknownHostException, IOException {
		return new ServerSocket(8080, 5, InetAddress.getByName("127.0.0.1"));
	}
	public static void main(String[] args) {
		Test test = new Test();
		try {
			test.server = test.initialize();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Thread thread = new Thread(test);
		thread.start();
		try {
			Thread.currentThread().sleep(1000);
			test.server.close();
		}catch (IOException e) {
			System.out.println("main IO");
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
