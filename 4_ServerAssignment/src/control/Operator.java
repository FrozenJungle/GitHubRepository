package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.DBConnection;
import model.Book;
import util.Parser;
import util.Protocol;

public class Operator {
	
	
	public String doOper(String receiveStr){
		Parser parser = new Parser();
		String[] parsedStr = parser.MyParser(receiveStr);
		String oper = parsedStr[0];
		boolean isSuccess = false;
		switch (oper) {
		case "addbook": { // addbook:bookname, author, price
			isSuccess = addbook(parsedStr[1], parsedStr[2], Float.parseFloat(parsedStr[3]));
			return String.valueOf(isSuccess);
		}
		case "delbybookname": { // delbybookname:bookname
			isSuccess = delbybookname(parsedStr[1]);
			return String.valueOf(isSuccess);
		}
		case "delbyauthor": {
			isSuccess = delbyauthor(parsedStr[1]);
			return String.valueOf(isSuccess);
		}
		case "fndbybookname": {
			ArrayList<Book> booklist = fndbybookname(parsedStr[1]);
			Protocol protocol = new Protocol();
			String returnStr = protocol.getFndMsg(booklist);
			System.out.println("returnStr: " + returnStr);
			return returnStr;
		}
		case "fndbyauthor": {
			ArrayList<Book> booklist = fndbyauthor(parsedStr[1]);
			Protocol protocol = new Protocol();
			String returnStr = protocol.getFndMsg(booklist);
			return returnStr;
		}
		case "fndbyprice": {
			ArrayList<Book> booklist = fndbyprice(Float.parseFloat(parsedStr[1]),
					Float.parseFloat(parsedStr[2]));
			Protocol protocol = new Protocol();
			String returnStr = protocol.getFndMsg(booklist);
			return returnStr;
		}
		case "altbook": {
			isSuccess = altbook(parsedStr[1], parsedStr[2], parsedStr[3], Float.parseFloat(parsedStr[4]));
			return String.valueOf(isSuccess);
		}
		case "prtallbook": {
			ArrayList<Book> booklist = BookList();
			Protocol protocol = new Protocol();
			String returnStr = protocol.getFndMsg(booklist);
			return returnStr;
		}
		default:
			return "false";
		}
		
	}

	

	public ArrayList<Book> BookList() {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist;";
			ResultSet rs = sta.executeQuery(sql);
			ArrayList<Book> booklist = new ArrayList<Book>();
			while (rs.next()) {
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				Book book = new Book(bookname, author, price);
				booklist.add(book);
			}
			return booklist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean addbook(String bookname, String author, float price) {

		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "insert into booklist values('" + bookname + "','" + author + "'," + price + ");";
			int rs = sta.executeUpdate(sql);
			if (rs != 0) {
				return true;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean delbybookname(String bookname) {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "delete from booklist where bookname = " + "'" + bookname + "';";
			System.out.println(sql);
			int rs = sta.executeUpdate(sql);
			if (rs != 0) {
				return true;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean delbyauthor(String author) {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "delete from booklist where author = " + "'" + author + "';";
			// System.out.println(sql);
			int rs = sta.executeUpdate(sql);
			if (rs != 0) {
				return true;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Book> fndbybookname(String bknm) {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist where(bookname ='" + bknm + "');";
			// System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			ArrayList<Book> booklist = new ArrayList<Book>();

			while (rs.next()) {
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				Book book = new Book(bookname, author, price);
				booklist.add(book);
			}

			return booklist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Book> fndbyauthor(String autr) {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist where(author ='" + autr + "')";
			// System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			ArrayList<Book> booklist = new ArrayList<Book>();
			while (rs.next()) {
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				Book book = new Book(bookname, author, price);
				booklist.add(book);
			}
			return booklist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Book> fndbyprice(float lowbound, float upbound) {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist where(price between " + lowbound + " and " + upbound + ");";
			ResultSet rs = sta.executeQuery(sql);
			ArrayList<Book> booklist = new ArrayList<Book>();
			while (rs.next()) {
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				Book book = new Book(bookname, author, price);
				booklist.add(book);
			}
			return booklist;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean altbook(String cursorbookname, String bookname, String author, float price) {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "update booklist set bookname='" + bookname + "',author='" + author + "',price=" + price
					+ " where(bookname='" + cursorbookname + "');"; 
			int rs = sta.executeUpdate(sql);
			if (rs != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
