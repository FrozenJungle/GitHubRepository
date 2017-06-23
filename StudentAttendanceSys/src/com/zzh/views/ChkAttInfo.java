package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zzh.dao.TeacherEntityDAO;
import com.zzh.dao.impl.TeacherEntityDAOImpl;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ChkAttInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public ChkAttInfo(String[][] tab,int id) {
		super("查看考勤信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton button = new JButton("返回上级菜单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkAttInfo.this.dispose();
				TeaMainFrame t = new TeaMainFrame(id);
				t.setVisible(true);
			}
		});
		contentPane.add(button, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String[] cn = {"课程号","课程名","学生Id","姓名","考勤时间","考勤状态"};
		table = new JTable(tab,cn);
		scrollPane.setViewportView(table);
	}

}
