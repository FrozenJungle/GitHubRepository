package util;

public class Protocol {

	public String getAddBookMsg(String bookname, String author, float price) {
		// 发送的消息格式：oper:para1,para2,para3...
		String msgStr = "addbook:" + bookname + "," + author + "," + price + "\n";
		return msgStr;
	}

	public String getDelByBooknameMsg(String bookname) {
		String msgStr = "delbybookname:" + bookname + "\n";
		return msgStr;
	}

	public String getDelByAuthorMsg(String author) {
		String msgStr = "delbyauthor:" + author + "\n";
		return msgStr;
	}

	public String getDelByPriceMsg(float lowbound, float upbound) {
		String msgStr = "delbyprice:" + lowbound + "," + upbound + "\n";
		return msgStr;
	}

	public String getFndByBooknameMsg(String bookname) {
		String msgStr = "fndbybookname:" + bookname + "\n";
		return msgStr;
	}

	public String getFndByAuthorMsg(String author) {
		String msgStr = "fndbyauthor:" + author + "\n";
		return msgStr;
	}

	public String getFndByPriceMsg(float lowbound, float upbound) {
		String msgStr = "fndbyprice:" + lowbound + "," + upbound + "\n";
		return msgStr;
	}

	public String getAltBookMsg(String cursorbookname, String bookname, String author, float price) {
		String msgStr = "altbook:" + cursorbookname + "," + bookname + "," + author + "," + price + "\n";
		return msgStr;
	}

	public String getPrtAllBookMsg() {
		String msgStr = "prtallbook:null\n";
		return msgStr;
	}

}
