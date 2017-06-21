package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zzh.control.Operator;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StuMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public StuMainFrame(int stuId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 150, 145);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel idLabel = new JLabel(String.valueOf(stuId));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(0, 75, 150, 35);
		panel.add(idLabel);

		JLabel staLabel = new JLabel("欢迎你！");
		staLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		staLabel.setHorizontalAlignment(SwingConstants.CENTER);
		staLabel.setBounds(0, 28, 150, 35);
		panel.add(staLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 150, 150, 265);
		contentPane.add(panel_1);

		JButton btnNewButton = new JButton("查看个人信息");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkInfo chkInfo = new ChkInfo(stuId);
				chkInfo.setVisible(true);
				StuMainFrame.this.dispose();

			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("修改个人信息");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltInfo altInfo = new AltInfo(stuId);
				altInfo.setVisible(true);
				StuMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改个人密码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltPwd altPwd = new AltPwd(stuId);
				altPwd.setVisible(true);
				StuMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("查看教师信息");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkTeacherInfo chkTeacherInfo = new ChkTeacherInfo();
				chkTeacherInfo.setVisible(true);
				StuMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("查看课程信息");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkCourseInfo chkCourseInfo = new ChkCourseInfo();
				chkCourseInfo.setVisible(true);
				StuMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(160, 0, 340, 70);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("请输入要查询考勤记录的课程编号：");
		label.setBounds(6, 6, 208, 16);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(label);

		textField = new JTextField();
		textField.setBounds(6, 26, 190, 26);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(textField);
		textField.setColumns(20);

		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator operator = new Operator();

			}
		});
		button.setBounds(219, 26, 75, 29);
		panel_2.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 75, 330, 345);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
