package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {

	private static Map<Integer, Socket> connHash = new HashMap<Integer, Socket>();

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
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Server();
	}

	public static Map<Integer, Socket> getConnHash() {
		return connHash;
	}

}
