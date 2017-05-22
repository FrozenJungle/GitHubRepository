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

public class DelBookUI extends JFrame {

	private JPanel contentPane;
	private JTextField booknameText;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DelBookUI frame = new DelBookUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DelBookUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("书名：");
		label.setBounds(76, 116, 54, 16);
		contentPane.add(label);
		
		booknameText = new JTextField();
		booknameText.setBounds(192, 111, 130, 26);
		contentPane.add(booknameText);
		booknameText.setColumns(10);
		
		button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname = booknameText.getText();

				Operator operator = new Operator();
				boolean isSuccess = operator.delbybookname(bookname);
				DelBookUI.this.dispose();
				if(isSuccess){
					JOptionPane.showMessageDialog(null, "成功！");	
				}else{
					JOptionPane.showMessageDialog(null, "失败！");
				}
				FirstUI firstui = new FirstUI();
				firstui.setVisible(true);
			}
		});
		button.setBounds(87, 210, 117, 29);
		contentPane.add(button);
		
		button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelBookUI.this.dispose();
				FirstUI firstui = new FirstUI();
				firstui.setVisible(true);
			}
		});
		
		button_1.setBounds(258, 210, 117, 29);
		contentPane.add(button_1);
		
		
		
	}

}
