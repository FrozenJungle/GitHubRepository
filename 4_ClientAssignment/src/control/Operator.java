package control;

import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {
	public boolean addBook(String bookname, String author, float price) {

		Protocol protocol = new Protocol();
		String msg = protocol.getAddBookMsg(bookname, author, price); // 打包查询语句
		Client.write(msg); // 发送信息给服务器，服务器处理请求
		String returnStr = Client.read();  
		System.out.println(returnStr);
		Parser parser = new Parser();
		boolean isSuccess = parser.getIsSuccess(returnStr);
		return isSuccess;

	}

	public boolean delBookByBookname(String bookname) {
		Protocol protocol = new Protocol();
		String msg = protocol.getDelByBooknameMsg(bookname);
		Client.write(msg);
		String returnStr = Client.read();
		Parser parser = new Parser();
		boolean isSuccess = parser.getIsSuccess(returnStr);
		return isSuccess;
	}

	public boolean delBookByAuthor(String author) {
		Protocol protocol = new Protocol();
		String msg = protocol.getDelByAuthorMsg(author);
		Client.write(msg);
		String returnStr = Client.read();
		Parser parser = new Parser();
		boolean isSuccess = parser.getIsSuccess(returnStr);
		return isSuccess;
	}

	public boolean delBookByPrice(float lowBound, float upBound) {
		Protocol protocol = new Protocol();
		String msg = protocol.getDelByPriceMsg(lowBound, upBound);
		Client.write(msg);
		String returnStr = Client.read();
		Parser parser = new Parser();
		boolean isSuccess = parser.getIsSuccess(returnStr);
		return isSuccess;
	}

	public String[][] fndByBookname(String bookname) {
		Protocol protocol = new Protocol();
		String msg = protocol.getFndByBooknameMsg(bookname);
		Client.write(msg);
		String returnStr = Client.read();
		Parser parser = new Parser();
		String[][] booklist = parser.fndBookParser(returnStr);
		return booklist;
	}

	public String[][] fndByAuthor(String author) {
		Protocol protocol = new Protocol();
		String msg = protocol.getFndByAuthorMsg(author);
		Client.write(msg);
		String returnStr = Client.read();
		Parser parser = new Parser();
		String[][] booklist = parser.fndBookParser(returnStr);
		return booklist;
	}

	public String[][] fndByPrice(float lowbound, float upbound) {
		Protocol protocol = new Protocol();
		String msg = protocol.getFndByPriceMsg(lowbound, upbound);
		Client.write(msg);
		String returnStr = Client.read();
		Parser parser = new Parser();
		String[][] booklist = parser.fndBookParser(returnStr);
		return booklist;
	}

	public boolean altBook(String bookname, String altbookname, String altauthor, float altprice) {
		Protocol protocol = new Protocol();
		String msg = protocol.getAltBookMsg(bookname, altbookname, altauthor, altprice);
		Client.write(msg);
		String returnStr = Client.read();
		Parser parser = new Parser();
		boolean isSuccess = parser.getIsSuccess(returnStr);
		return isSuccess;
	}

	public String[][] prtAllBook() {
		Protocol protocol = new Protocol();
		String msg = protocol.getPrtAllBookMsg();
		Client.write(msg);
		System.out.println("msg:" + msg);
		String returnStr = Client.read();
		System.out.println("returnStr:" + returnStr);
		Parser parser = new Parser();
		String[][] booklist = parser.fndBookParser(returnStr);
		return booklist;
	}

}
