package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BookListUI extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private JButton button;

	public BookListUI(String[][] booklist) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());


		String[] columnNames = { "书名", "作者名", "价格" };
		table = new JTable(booklist, columnNames);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(450, 200);
		scroll.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(scroll);

		button = new JButton("好的");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookListUI.this.dispose();
				
			}
		});
		contentPane.add(button, BorderLayout.SOUTH);

		this.setVisible(true);
	}

}
