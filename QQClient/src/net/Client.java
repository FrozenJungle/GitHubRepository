package net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static Socket tcpConn = null;
	public static Scanner in;
	public static OutputStream out;
	
	static{		//静态代码块，在类加载时被执行
		try {
			tcpConn = new Socket("127.0.0.1",1234);
			in = new Scanner(tcpConn.getInputStream());
			out = tcpConn.getOutputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void write(String msg){
		try {
			out.write(msg.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static String read(){
		return in.nextLine();
	}
	
	public static void close(){

		try {
			write("0\n");
			in.close();
			out.close();
			tcpConn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Client();

	}
}
