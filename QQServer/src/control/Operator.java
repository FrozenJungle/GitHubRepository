package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import database.DBConnection;
import util.Parser;
import util.Protocol;

public class Operator {

	Map<Integer, Socket> connHash = new HashMap<Integer, Socket>();
	Integer userId;

	public Operator(Map<Integer, Socket> connHash, Integer userId) {
		this.connHash = connHash;
		this.userId = userId;
	}

	public String doOper(String operStr) {
		boolean isSuccess = false;
		Parser parser = new Parser();
		String[] parsedStr = parser.operParser(operStr);
		if (parsedStr.equals(null))
			return null;
		String oper = parsedStr[0];
		switch (oper) {
		case "login": { // login:userId,password 查询数据库
			isSuccess = login(Integer.parseInt(parsedStr[1]), parsedStr[2]);
			return String.valueOf(isSuccess);
		}
		case "chat": { // chat:toWhom|content 消息转发
			chat(connHash, userId, parsedStr);
			return null;
		}
		default:
			return null;
		}

	}

	public boolean login(int userId, String password) {
		Connection conn = null;
		Statement sta = null;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select password from userinfo where (id='" + userId + "');";
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				String pswd = rs.getString("password");
				if (pswd.equals(password))
					return true;
				else
					return false;
			} else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void chat(Map<Integer, Socket> connHash, Integer userId, String[] parsedStr) {
		Integer toWhom = Integer.parseInt(parsedStr[1]);
		Socket tcpConnTo = connHash.get(toWhom);

		OutputStream out;
		try {
			out = tcpConnTo.getOutputStream();
			Protocol protocol = new Protocol(connHash, userId);
			String chatRtnMsg = protocol.chatRtnMsg(parsedStr);
			out.write((chatRtnMsg + "\n").getBytes()); // 此处write的是客户端接受的chat消息,
														// fromWhom|toWhom|content
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
