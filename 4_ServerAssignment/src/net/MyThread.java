package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import control.Operator;

public class MyThread extends Thread {

	Socket tcpConn;

	public MyThread(Socket tcpConn) {
		this.tcpConn = tcpConn;
	}

	public void run() {
		try {
			InputStream in = tcpConn.getInputStream();
			BufferedReader netIn = new BufferedReader(new InputStreamReader(in));
			OutputStream out = tcpConn.getOutputStream();
			
			while (true) {
				String receiveStr = netIn.readLine();
				System.out.println("收到客户端数据：" + receiveStr);
				if(receiveStr.equals("0"))
					break;
				Operator operator = new Operator();
				String returnStr = operator.doOper(receiveStr);
				out.write((returnStr+"\n").getBytes());
			}

			in.close();
			out.close();
			tcpConn.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
