package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBounds(500,300,350,200);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname = booknameText.getText();
				String altbookname = altbooknameText.getText();
				String altauthor = altauthorText.getText();
				float altprice = 0;
				try{
					altprice = Float.parseFloat(altpriceText.getText());
					Operator operator = new Operator();
					boolean isSuccess = operator.altBook(bookname, altbookname, altauthor, altprice);
					if (isSuccess) {
						JOptionPane.showMessageDialog(null, "修改成功！");
					} else {
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
				} catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "修改失败！\n请检查类型");
				}
				AltBookUI.this.dispose();
			}
		});
		button.setBounds(89, 221, 117, 29);
		contentPane.add(button);

		button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltBookUI.this.dispose();
			}
		});

		button_1.setBounds(259, 221, 117, 29);
		contentPane.add(button_1);

		JLabel bookname = new JLabel("书名：");
		bookname.setBounds(74, 55, 54, 16);
		contentPane.add(bookname);

		booknameText = new JTextField();
		booknameText.setBounds(189, 50, 130, 26);
		contentPane.add(booknameText);
		booknameText.setColumns(10);

		altbookname = new JLabel("修改后的书名：");
		altbookname.setBounds(74, 95, 91, 16);
		contentPane.add(altbookname);

		altbooknameText = new JTextField();
		altbooknameText.setColumns(10);
		altbooknameText.setBounds(189, 90, 130, 26);
		contentPane.add(altbooknameText);

		altauthor = new JLabel("修改后的作者：");
		altauthor.setBounds(74, 135, 91, 16);
		contentPane.add(altauthor);

		altprice = new JLabel("修改后的价格：");
		altprice.setBounds(74, 175, 91, 16);
		contentPane.add(altprice);

		altauthorText = new JTextField();
		altauthorText.setColumns(10);
		altauthorText.setBounds(189, 130, 130, 26);
		contentPane.add(altauthorText);

		altpriceText = new JTextField();
		altpriceText.setColumns(10);
		altpriceText.setBounds(189, 170, 130, 26);
		contentPane.add(altpriceText);

	}

}
