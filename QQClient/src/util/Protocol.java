package util;

public class Protocol {

//	public String getAddBookMsg(String bookname, String author, float price) {
//		// 发送的消息格式：oper:para1,para2,para3...
//		String msgStr = "addbook:" + bookname + "," + author + "," + price + "\n";
//		return msgStr;
//	}

	public String getLoginMsg(int userId, String password){
		return userId+"|userid|"+"login:" + userId + "," + password + "\n";
	}
	public String getChatMsg(int fromWhom,int toWhom,String content){
		return fromWhom+"|userid|"+"chat:"+toWhom+"|"+ content;
	}
	
}
