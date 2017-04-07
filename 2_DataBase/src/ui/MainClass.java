package ui;

import model.Book;

import java.util.ArrayList;
import java.util.Scanner;

import control.Operator;

public class MainClass {

	ArrayList<Book> booklist = new ArrayList<Book>();

	public MainClass() {

		Scanner scan = new Scanner(System.in);
		System.out.println("欢迎来到图书管理系统！");
		while (true) {
			System.out.println("-·-·-·-·-·-·-·-·-");
			System.out.println("|   增加图书——1   |");
			System.out.println("|   删除图书——2   |");
			System.out.println("|   修改图书——3   |");
			System.out.println("|   查询图书——4   |");
			System.out.println("|   打印书单——5   |");
			System.out.println("|    退出——6     |");
			System.out.println("-·-·-·-·-·-·-·-·-");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				addbook();
				break;
			case 2:
				 delbook();
				 break;
			case 3:
				altbook();
				break;
			case 4:
				fndbook();
				break;
			case 5:
				printallbook();
				break;
			case 6:
				System.out.println("拜拜！");
				return;
			}
		}
	}

	void addbook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入书名：");
		String bookname = scan.next();
		System.out.println("请输入作者：");
		String author = scan.next();
		System.out.println("请输入价格：");
		float price = scan.nextFloat();
		Operator operator = new Operator();
		boolean isSuccess = operator.addBook(bookname, author, price);
		if (isSuccess)
			System.out.printf("成功，已增加图书:%s\n", bookname);
		else
			System.out.printf("插入失败！");
	}

	void printallbook() {
		Operator operator = new Operator();
		ArrayList<Book> booklist = operator.BookList();
		for (int i = 0; i < booklist.size(); i++) {
			String bookname = booklist.get(i).getBookname();
			String author = booklist.get(i).getAuthor();
			float price = booklist.get(i).getPrice();
			System.out.println("第" + (i+1) + "本书： " + bookname + " " + author + " " + price);
		}
	}
	
	void delbook(){
		Scanner scan = new Scanner(System.in);
		System.out.println("按书名删除：----1");
		System.out.println("按作者名删除:----2");
		int choice = scan.nextInt();
		switch(choice){
		case 1:{
			Scanner scan_ = new Scanner(System.in);
			System.out.println("请输入书名：");
			String bookname = scan_.nextLine();
			Operator operator = new Operator();
			boolean isSuccess = operator.delbybookname(bookname);
			if(isSuccess==true)
				System.out.println("删除成功");
			else System.out.println("删除失败");
		}break;
		case 2:{
			Scanner scan_ = new Scanner(System.in);
			System.out.println("请输入作者名：");
			String author = scan_.nextLine();
			Operator operator = new Operator();
			boolean isSuccess = operator.delbyauthor(author);
			if(isSuccess==true)
				System.out.println("删除成功");
			else System.out.println("删除失败");
		}break;
		}
	}
	
	void fndbook(){
		Scanner scan = new Scanner(System.in);
		System.out.println("按书名检索：----1");
		System.out.println("按作者名检索:----2");
		System.out.println("按价格检索----3");
		int choice = scan.nextInt();
		switch(choice){
			case 1:{
				Scanner scan_ = new Scanner(System.in);
				System.out.println("请输入书名：");
				String bknm = scan_.nextLine();
				Operator operator = new Operator();
				ArrayList<Book> booklist = new ArrayList<Book>();
				booklist = operator.fndbybookname(bknm);
				if(booklist.size()==0){
					System.out.println("查无此书！");
					return;
				}
				for (int i = 0; i < booklist.size(); i++) {
					String bookname = booklist.get(i).getBookname();
					String author = booklist.get(i).getAuthor();
					float price = booklist.get(i).getPrice();
					System.out.println("找到的第" + (i+1) + "本书： " + bookname + " " + author + " " + price);
				}
	
			}
			break;
			case 2:{
				Scanner scan_ = new Scanner(System.in);
				System.out.println("请输入作者名：");
				String autr = scan_.nextLine();
				Operator operator = new Operator();
				ArrayList<Book> booklist = new ArrayList<Book>();
				booklist = operator.fndbyauthor(autr);
				if(booklist.size()==0){
					System.out.println("查无此书！");
					return;
				}
				for (int i = 0; i < booklist.size(); i++) {
					String bookname = booklist.get(i).getBookname();
					String author = booklist.get(i).getAuthor();
					float price = booklist.get(i).getPrice();
					System.out.println("找到的第" + (i+1) + "本书： " + bookname + " " + author + " " + price);
				}
			}
			break;
			case 3:{
				Scanner scan_ = new Scanner(System.in);
				System.out.println("请输入价格下界");
				float lowbound = scan_.nextFloat();
				Scanner scan__ = new Scanner(System.in);
				System.out.println("请输入价格上界");
				float upbound = scan__.nextFloat();
				Operator operator = new Operator();
				ArrayList<Book> booklist = new ArrayList<Book>();
				booklist = operator.fndbyprice(lowbound,upbound);
				if(booklist.size()==0){
					System.out.println("查无此书！");
					return;
				}
				for (int i = 0; i < booklist.size(); i++) {
					String bookname = booklist.get(i).getBookname();
					String author = booklist.get(i).getAuthor();
					float price = booklist.get(i).getPrice();
					System.out.println("找到的第" + (i+1) + "本书： " + bookname + " " + author + " " + price);
				}
			}
			break;
		}
	}
	
	void altbook(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要修改的书名：");
		String cursorbookname = scan.next();
		Operator operator = new Operator();
		Scanner scan_ = new Scanner(System.in);
		System.out.println("请输入修改后的书名：");
		String bookname = scan_.next();
		Scanner scan__ = new Scanner(System.in);
		System.out.println("请输入修改后的作者：");
		String author = scan__.next();
		Scanner scan___ = new Scanner(System.in);
		System.out.println("请输入修改后的价格：");
		float price = scan___.nextFloat();
		operator.altbook(cursorbookname, bookname, author, price);

	}
	

	public static void main(String[] args) {
		new MainClass();
	}
}
