package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import control.Operator;
import util.Parser;

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
				String receiveStr = netIn.readLine(); // 244116836|userid|chat:toWhom|content
				System.out.println("receiveStr:" + receiveStr);
				String[] idStrs;
				Integer userId = 0;
				String operStr = "";
				// 客户端退出就在Map中remove连接
				if (!receiveStr.equals("0")) {
					Parser parser = new Parser();
					idStrs = parser.idParser(receiveStr);
					userId = Integer.parseInt(idStrs[0]);
					operStr = idStrs[1];
				} else {
					Server.getConnHash().remove(userId);
					break;
				}
				Server.getConnHash().put(userId, tcpConn);
				Operator operator = new Operator(Server.getConnHash(), userId);
				if (operStr.startsWith("chat")) {
					operator.doOper(operStr);
				} else {
					String returnStr = operator.doOper(operStr);
					out.write((returnStr + "\n").getBytes());
				}
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
