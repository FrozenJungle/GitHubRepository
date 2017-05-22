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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Button;

public class FirstUI extends JFrame {

	
	//private JPanel contentPane1;
	private JPanel titlePane = new JPanel();
	private JPanel contentPane = new JPanel();
	private JPanel buttonsPane = new JPanel();
	private JTabbedPane tabPane = new JTabbedPane();
	private JLabel label1,label2,label3;
	private JPanel panel1,panel2,panel3;


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

	}
	
	private void content(){

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
		titlePane.setBounds(300,300,100,100);
		titlePane.setBorder(new EmptyBorder(20,20,20,20));
		JLabel labelTitle = new JLabel("欢迎来到图书管理系统！");
		labelTitle.setFont(new Font("PingFang SC", Font.PLAIN, 21));
		titlePane.add(labelTitle);
		getContentPane().add(titlePane,BorderLayout.NORTH);	
		
		
		buttonsPane.add(buttonadd);
		buttonsPane.add(buttondel);
		buttonsPane.add(buttonalt);
		buttonsPane.add(buttonfnd);
		buttonsPane.add(buttonprt);
		buttonsPane.setLayout(new GridLayout(5,1));
		getContentPane().add(buttonsPane, "Center");
		//getContentPane().add(contentPane,BorderLayout.CENTER);
		
		
		buttonadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookUI addbookui = new AddBookUI();
				addbookui.setVisible(true);
				FirstUI.this.dispose();
			}
		});
		
		buttondel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelBookUI delbookui = new DelBookUI();
				delbookui.setVisible(true);
				FirstUI.this.dispose();
			}
		});
		
		buttonalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltBookUI altbookui = new AltBookUI();
				altbookui.setVisible(true);
				FirstUI.this.dispose();
			}
		});
		
		buttonfnd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SelBookUI selbookui = new SelBookUI();
				selbookui.setVisible(true);
				FirstUI.this.dispose();
			}
		});
		
		buttonprt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}

}
