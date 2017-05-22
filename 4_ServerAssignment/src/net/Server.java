package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		ServerSocket ss = null;

		try {
			ss = new ServerSocket(1234);
			System.out.println("服务器已启动，等待客户端连接...");
			
			while (true) {
				
				Socket tcpConn = ss.accept();
				System.out.println("客户端已连接，来自" + tcpConn.getInetAddress() + ":" + tcpConn.getPort());
				MyThread myThread = new MyThread(tcpConn);
				myThread.start();
				System.out.println("服务器继续等待客户端连接...");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Server();
	}

}
