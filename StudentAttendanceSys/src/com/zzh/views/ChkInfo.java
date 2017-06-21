package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zzh.bean.StudentEntity;
import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChkInfo extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField idText;
	private JTextField collegeText;
	private JTextField majorText;
	private JTextField emailText;

	public ChkInfo(int stuId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JLabel label = new JLabel("姓名：");
		label.setBounds(20, 20, 61, 16);
		contentPane.add(label);

		nameText = new JTextField();
		nameText.setEditable(false);
		nameText.setBounds(77, 15, 130, 26);
		contentPane.add(nameText);
		nameText.setColumns(10);

		JLabel label_1 = new JLabel("学号：");
		label_1.setBounds(20, 66, 61, 16);
		contentPane.add(label_1);

		JLabel lblNewLabel = new JLabel("学院：");
		lblNewLabel.setBounds(20, 109, 61, 16);
		contentPane.add(lblNewLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(77, 61, 130, 26);
		contentPane.add(idText);
		idText.setColumns(10);

		collegeText = new JTextField();
		collegeText.setEditable(false);
		collegeText.setBounds(77, 104, 130, 26);
		contentPane.add(collegeText);
		collegeText.setColumns(10);

		JLabel label_2 = new JLabel("专业：");
		label_2.setBounds(20, 158, 61, 16);
		contentPane.add(label_2);

		majorText = new JTextField();
		majorText.setEditable(false);
		majorText.setBounds(77, 153, 130, 26);
		contentPane.add(majorText);
		majorText.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail：");
		lblEmail.setBounds(20, 209, 61, 16);
		contentPane.add(lblEmail);

		emailText = new JTextField();
		emailText.setEditable(false);
		emailText.setBounds(77, 204, 130, 26);
		contentPane.add(emailText);
		emailText.setColumns(10);

		

		JButton button_1 = new JButton("确定");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkInfo.this.dispose();
				StuMainFrame s = new StuMainFrame(stuId);
				s.setVisible(true);

			}
		});
		button_1.setBounds(118, 261, 117, 29);
		contentPane.add(button_1);
		
		StudentEntityDAO stuEn = new StudentEntityDAOImpl();
		StudentEntity se = stuEn.fndStuById(stuId);
		nameText.setText(se.getStudent_name());
		idText.setText(String.valueOf(stuId));
		collegeText.setText(se.getStudent_college());
		majorText.setText(se.getStudent_major());
		emailText.setText(se.getStudent_email());
	}
}
