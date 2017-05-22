package util;

import java.util.ArrayList;

import model.Book;

public class Protocol {

	/*
	 * 服务器端的Protocol是将返回信息转为格式字符串
	 */

	public String getFndMsg(ArrayList<Book> booklist) {
		String returnStr = "";
		for (int i = 0; i < booklist.size(); i++) {
			String bookname = booklist.get(i).getBookname();
			String author = booklist.get(i).getAuthor();
			String price = Float.toString(booklist.get(i).getPrice());
			returnStr = returnStr + bookname + "," + author + "," + price + "|";
		}
		return returnStr.substring(0, returnStr.length()-1);
		// 返回字符串格式：bookname,author,price|bookname,author,price...
	}
}
