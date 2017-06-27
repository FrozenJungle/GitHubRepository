package util;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Protocol {
	
	Map<Integer, Socket> connHash = new HashMap<Integer, Socket>();
	Integer userId;

	public Protocol(Map<Integer, Socket> connHash, Integer userId) {
		this.connHash = connHash;
		this.userId = userId;
	}


	public String chatRtnMsg(String[] parsedStr){
		String fromWhom = userId.toString();
		String toWhom = parsedStr[1];
		String content = parsedStr[2];
		return fromWhom+"|"+toWhom+"|"+content;
	}
}
