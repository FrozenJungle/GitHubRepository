package util;

public class Parser {

	public String[] idParser(String receiveStr) {
		String[] splt = receiveStr.split("\\|userid\\|");
		return splt;
	}

	public String[] operParser(String operStr) {
		String[] splt = operStr.split(":");
		String oper = splt[0];
		String attr = splt[1];
		switch (oper) {
		case "login": { // login:userid,password
			String attrs[] = attr.split(",");
			String userid = attrs[0];
			String password = attrs[1];
			String[] parsedStr = { "login", userid, password };
			return parsedStr;
		}
		case "chat": { // chat:towhom|content
			String attrs[] = attr.split("\\|");
			if(!attrs[1].equals(null)){
				String toWhom = attrs[0];
				String content = attrs[1];
				String[] parsedStr = { "chat",toWhom, content };
				return parsedStr;
			} 
			return null;
		}
		default:
			return null;
		}
	}
	

}
