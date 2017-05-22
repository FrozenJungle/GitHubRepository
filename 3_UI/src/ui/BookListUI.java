package ui;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Book;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class BookListUI extends JFrame {
	private JTable table;

	public BookListUI(Object[][] booklist) {
		getContentPane().setLayout(new BorderLayout(10, 10));

		table = new JTable();
		getContentPane().add(table);
		String[] columnNames = { "bookname", "author", "price" };

		DefaultTableModel model = new DefaultTableModel(booklist, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		

	}
}
