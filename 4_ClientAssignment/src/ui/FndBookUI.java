package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Operator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FndBookUI extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel panel1, panel2, panel3;
	private JTextField textField1,textField2,textField3,textField4;
	private JButton yesbutton1, yesbutton2, yesbutton3;


	/**
	 * Create the frame.
	 */
	public FndBookUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 250, 450, 300);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		JButton rtnbutton1 = new JButton("返回");
		rtnbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FndBookUI.this.dispose();
			}
		});
		panel1.setLayout(null);
		rtnbutton1.setBounds(210, 157, 75, 29);
		panel1.add(rtnbutton1);
		
		JButton rtnbutton2 = new JButton("返回");
		rtnbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FndBookUI.this.dispose();
			}
		});
		panel2.setLayout(null);
		rtnbutton2.setBounds(210, 157, 75, 29);
		panel2.add(rtnbutton2);
		
		JButton rtnbutton3 = new JButton("返回");
		rtnbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FndBookUI.this.dispose();
			}
		});
		panel3.setLayout(null);
		rtnbutton3.setBounds(210, 157, 75, 29);
		panel3.add(rtnbutton3);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 438, 34);
		tabbedPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabbedPane.addTab("按书名查找", panel1);
		tabbedPane.addTab("按作者名查找", panel2);
		tabbedPane.addTab("按价格区间查找", panel3);
		
		JLabel label3 = new JLabel("价格下界：");
		label3.setBounds(86, 92, 70, 16);
		panel3.add(label3);
		JLabel label4 = new JLabel("价格上界：");
		label4.setBounds(86, 43, 70, 16);
		panel3.add(label4);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(168, 38, 130, 26);
		panel3.add(textField3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(168, 87, 130, 26);
		panel3.add(textField4);
		
		getContentPane().add(tabbedPane);
		setVisible(true);
		
		JLabel label1 = new JLabel("书名：");
		label1.setBounds(96, 74, 39, 16);
		panel1.add(label1);
		
		textField1 = new JTextField();
		textField1.setBounds(168, 69, 130, 26);
		panel1.add(textField1);
		textField1.setColumns(10);
		
		yesbutton1 = new JButton("确定");
		yesbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname = textField1.getText();
				Operator operator = new Operator();
				String[][] booklist = operator.fndByBookname(bookname);
				if(booklist.length == 0){
					JOptionPane.showMessageDialog(null, "失败,查无此书！");
					FndBookUI.this.dispose();
				}else{
					FndBookUI.this.dispose();
					BookListUI booklistui = new BookListUI(booklist);
					booklistui.setVisible(true);
				}
				
			}
		});
		yesbutton1.setBounds(109, 157, 75, 29);
		panel1.add(yesbutton1);
		
		yesbutton2 = new JButton("确定");
		yesbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String author = textField2.getText();
				Operator operator = new Operator();
				String[][] booklist = operator.fndByAuthor(author);
				if(booklist.length == 0){
					JOptionPane.showMessageDialog(null, "失败,查无此书！");
					FndBookUI.this.dispose();
				}else{
					FndBookUI.this.dispose();
					BookListUI booklistui = new BookListUI(booklist);
					booklistui.setVisible(true);
				}
			}
		});
		yesbutton2.setBounds(109, 157, 75, 29);
		panel2.add(yesbutton2);
		
		yesbutton3 = new JButton("确定");
		yesbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lowBound = textField3.getText();
				String upBound = textField4.getText();
				Operator operator = new Operator();
				String[][] booklist = operator.fndByPrice(Float.parseFloat(lowBound),Float.parseFloat(upBound));
				if(booklist.length == 0){
					JOptionPane.showMessageDialog(null, "失败,查无此书！");
					FndBookUI.this.dispose();
				}else{
					FndBookUI.this.dispose();
					BookListUI booklistui = new BookListUI(booklist);
					booklistui.setVisible(true);
				}
			}
		});
		yesbutton3.setBounds(109, 157, 75, 29);
		panel3.add(yesbutton3);
		
		JLabel label2 = new JLabel("作者名：");
		label2.setBounds(81, 74, 54, 16);
		panel2.add(label2);
		
		textField2 = new JTextField();
		textField2.setBounds(168, 69, 130, 26);
		panel2.add(textField2);
		textField2.setColumns(10);
		
	}
	
	
}
