package model;

public class Book {
	String bookname;
	String author;
	float price;
	
	public Book(String bookname,String author,float price){
		this.bookname = bookname;
		this.author = author;
		this.price = price;
	}
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
