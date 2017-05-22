package ui;

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

public class AddBookUI extends JFrame {

	private JPanel contentPane;
	private JTextField booknameText;
	private JTextField authorText;
	private JLabel label__;
	private JTextField priceText;
	private JButton button;
	private JButton button_1;


	/**
	 * Create the frame.
	 */
	public AddBookUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("书名：");
		label.setBounds(109, 41, 54, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("作者：");
		label_1.setBounds(109, 97, 54, 16);
		contentPane.add(label_1);
		
		label__ = new JLabel("价格：");
		label__.setBounds(109, 149, 54, 16);
		contentPane.add(label__);
		
		booknameText = new JTextField();
		booknameText.setBounds(202, 36, 130, 26);
		contentPane.add(booknameText);
		booknameText.setColumns(10);
		
		authorText = new JTextField();
		authorText.setBounds(202, 92, 130, 26);
		contentPane.add(authorText);
		authorText.setColumns(10);
		
		
		priceText = new JTextField();
		priceText.setColumns(10);
		priceText.setBounds(202, 144, 130, 26);
		contentPane.add(priceText);
		
		button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname = booknameText.getText();
				String author = authorText.getText();
				float price= 0;
				try{
					price = Float.parseFloat(priceText.getText());
					Operator operator = new Operator();
					boolean isSuccess = operator.addBook(bookname, author, price);
					if(isSuccess){
						JOptionPane.showMessageDialog(null, "添加成功！");	
					}else{
						JOptionPane.showMessageDialog(null, "添加失败！");
					}
				} catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "添加失败！\n请检查类型");
				}
					AddBookUI.this.dispose();
			}
		});
		button.setBounds(87, 210, 117, 29);
		contentPane.add(button);
		
		button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookUI.this.dispose();
			}
		});
		
		button_1.setBounds(258, 210, 117, 29);
		contentPane.add(button_1);
		
		
		
	}

}
