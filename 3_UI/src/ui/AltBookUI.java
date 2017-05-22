package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Operator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltBookUI extends JFrame {

	private JPanel contentPane;
	private JTextField booknameText;
	private JButton button;
	private JButton button_1;
	private JLabel altbookname;
	private JTextField altbooknameText;
	private JLabel altauthor;
	private JLabel altprice;
	private JTextField altauthorText;
	private JTextField altpriceText;


	/**
	 * Create the frame.
	 */
	public AltBookUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bookname = new JLabel("书名：");
		bookname.setBounds(74, 55, 54, 16);
		contentPane.add(bookname);
		
		booknameText = new JTextField();
		booknameText.setBounds(189, 50, 130, 26);
		contentPane.add(booknameText);
		booknameText.setColumns(10);
		
		button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname = booknameText.getText();
				String altbookname = altbooknameText.getText();
				String altauthor = altauthorText.getText();
				String altprice_ = altpriceText.getText();
				float altprice = Float.parseFloat(altprice_);
				Operator operator  = new Operator();
				boolean isSuccess = operator.altbook(bookname, altbookname, altauthor, altprice);
				if(isSuccess){
					JOptionPane.showMessageDialog(null, "成功！");	
				}else{
					JOptionPane.showMessageDialog(null, "失败！");
				}
				AltBookUI.this.dispose();
				FirstUI firstui = new FirstUI();
				firstui.setVisible(true);
			}
		});
		button.setBounds(87, 210, 117, 29);
		contentPane.add(button);
		
		button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltBookUI.this.dispose();
				FirstUI firstui = new FirstUI();
				firstui.setVisible(true);
			}
		});
		
		button_1.setBounds(258, 210, 117, 29);
		contentPane.add(button_1);
		
		altbookname = new JLabel("修改后的书名：");
		altbookname.setBounds(74, 96, 91, 16);
		contentPane.add(altbookname);
		
		altbooknameText = new JTextField();
		altbooknameText.setColumns(10);
		altbooknameText.setBounds(189, 91, 130, 26);
		contentPane.add(altbooknameText);
		
		altauthor = new JLabel("修改后的作者：");
		altauthor.setBounds(74, 135, 91, 16);
		contentPane.add(altauthor);
		
		altprice = new JLabel("修改后的价格：");
		altprice.setBounds(74, 173, 91, 16);
		contentPane.add(altprice);
		
		altauthorText = new JTextField();
		altauthorText.setColumns(10);
		altauthorText.setBounds(189, 129, 130, 26);
		contentPane.add(altauthorText);
		
		altpriceText = new JTextField();
		altpriceText.setColumns(10);
		altpriceText.setBounds(189, 168, 130, 26);
		contentPane.add(altpriceText);
		
		
		
	}

}
