package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Operator;
import net.Client;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Button;

public class FirstUI extends JFrame {

	private JPanel titlePane = new JPanel();
	private JPanel buttonsPane = new JPanel();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstUI frame = new FirstUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	

	public FirstUI() {
		super("图书管理系统");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 550, 400);
		content();
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				Client.write("0\n");
			}
		});

	}

	private void content() {

		JButton buttonadd = new JButton("增加图书");
		buttonadd.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		JButton buttondel = new JButton("删除图书");
		buttondel.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		JButton buttonalt = new JButton("修改图书");
		buttonalt.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		JButton buttonfnd = new JButton("查询图书");
		buttonfnd.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		JButton buttonprt = new JButton("打印书单");

		buttonprt.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		titlePane.setBounds(300, 300, 100, 100);
		titlePane.setBorder(new EmptyBorder(20, 20, 20, 20));
		JLabel labelTitle = new JLabel("欢迎来到图书管理系统！");
		labelTitle.setFont(new Font("PingFang SC", Font.PLAIN, 21));
		titlePane.add(labelTitle);
		getContentPane().add(titlePane, BorderLayout.NORTH);

		buttonsPane.add(buttonadd);
		buttonsPane.add(buttondel);
		buttonsPane.add(buttonalt);
		buttonsPane.add(buttonfnd);
		buttonsPane.add(buttonprt);
		buttonsPane.setLayout(new GridLayout(5, 1));
		getContentPane().add(buttonsPane, "Center");

		buttonadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookUI addbookui = new AddBookUI();
				addbookui.setVisible(true);
			}
		});

		buttondel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelBookUI delbookui = new DelBookUI();
				delbookui.setVisible(true);
			}
		});

		buttonalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltBookUI altbookui = new AltBookUI();
				altbookui.setVisible(true);
			}
		});

		buttonfnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FndBookUI selbookui = new FndBookUI();
				selbookui.setVisible(true);
			}
		});

		buttonprt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator operator = new Operator();
				String[][] booklist = operator.prtAllBook();
				BookListUI booklistui = new BookListUI(booklist);
				booklistui.setVisible(true);
			}
		});
		
		
	}
	
}
