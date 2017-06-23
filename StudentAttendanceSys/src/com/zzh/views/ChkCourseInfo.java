package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChkCourseInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public ChkCourseInfo(String[][] classList,int id) {
		super("修改课程信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(scrollPane, BorderLayout.CENTER);

		String[] colunmNames={"课程号","课程名称","教师名"};
		table = new JTable(classList,colunmNames);
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("课程信息");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton button = new JButton("返回上级菜单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkCourseInfo.this.dispose();
				StuMainFrame smf = new StuMainFrame(id);
				smf.setVisible(true);
			}
		});
		panel.add(button);
	}

}
