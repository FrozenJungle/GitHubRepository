package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;

public class ChkTeacherInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ChkTeacherInfo(String[][] teacherList,int id) {
		super("查看教师信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(scrollPane, BorderLayout.CENTER);

		
		String[] colunmNames = {"姓名","任课课程","所属学院"};
		table = new JTable(teacherList,colunmNames);
		
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("教师信息");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton button = new JButton("返回上级菜单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkTeacherInfo.this.dispose();
				StuMainFrame smf = new StuMainFrame(id);
				smf.setVisible(true);
			}
		});
		panel.add(button);
	}

}
