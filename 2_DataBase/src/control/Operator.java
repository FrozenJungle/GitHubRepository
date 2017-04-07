package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.DBConnection;
import model.Book;

public class Operator {
	public boolean addBook(String bookname, String author, float price) {

		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "insert into booklist values('" + bookname + "','" + author + "'," + price + ");";
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
	

	public ArrayList<Book> BookList() {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist;";
//			System.out.println(sql);
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
	
	public boolean delbybookname(String bookname){
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "delete from booklist where bookname = "+"'" +bookname+"';";
//			System.out.println(sql);
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
	
	public boolean delbyauthor(String author){
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "delete from booklist where author = "+"'" +author+"';";
//			System.out.println(sql);
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

	
	public ArrayList<Book> fndbybookname(String bknm){
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist where(bookname ='"+bknm+"');";
//			System.out.println(sql);
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
	
	public ArrayList<Book> fndbyauthor(String autr){
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist where(author ='"+autr+"')";
//			System.out.println(sql);
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
	
	public ArrayList<Book> fndbyprice(float lowbound, float upbound){
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select * from booklist where(price between "+lowbound+" and "+upbound+");";
//			System.out.println(sql);
			ResultSet rs = sta.executeQuery(sql);
			ArrayList<Book> booklist = new ArrayList<Book>(); 
			while(rs.next()){
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
		} finally{
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	
	public boolean altbook(String cursorbookname,String bookname, String author, float price){
		Connection conn = null;
		Statement sta = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "update booklist set bookname='"+bookname+"',author='"+author+"',price="+price+" where(bookname='"+cursorbookname+"');"; //update booklist set bookname= where(bookname = 'CPP');
//			System.out.println(sql);
			int rs = sta.executeUpdate(sql);
			if(rs!=0){
				System.out.println("修改成功！");
				return true;
			}else{
				System.out.println("查无此书，修改失败！");
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
