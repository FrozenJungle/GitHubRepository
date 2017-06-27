package util;


public class Parser {
	
	public boolean getIsSuccess(String returnStr){
		if(returnStr.equals("true"))
			return true;
		else return false;
	}

	public String[] getChatMessage(String receiveStr){
		return receiveStr.split("\\|");
	}
	
}
