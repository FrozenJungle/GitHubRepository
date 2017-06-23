package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zzh.bean.TeacherEntity;
import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class StuMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public StuMainFrame(int stuId) {
		super("主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 150, 165);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel idLabel = new JLabel(String.valueOf(stuId));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(0, 142, 150, 23);
		panel.add(idLabel);

		JLabel picLabel = new JLabel();
		String picURI = "/images/"+stuId+".png";
		ImageIcon image = new ImageIcon(this.getClass().getResource(picURI));
		image.setImage(image.getImage().getScaledInstance(150, 142, Image.SCALE_SMOOTH));
		picLabel.setIcon(image);
		picLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picLabel.setBounds(0, 0, 150, 142);
		panel.add(picLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 177, 150, 238);
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
				StudentEntityDAO stuEn = new StudentEntityDAOImpl();
				ArrayList<TeacherEntity> teacher = stuEn.fndTeaByStuId(stuId);
				int length = teacher.size();
				String[][] teacherStr = new String[length][3];
				int i = 0;
				for (TeacherEntity teacherE : teacher) {
					teacherStr[i][0] = teacherE.getTeacher_name();
					teacherStr[i][1] = teacherE.getCollege_name();
					teacherStr[i][2] = teacherE.getFaculty_name();
					i++;
				}
				ChkTeacherInfo chkTeacherInfo = new ChkTeacherInfo(teacherStr, stuId);
				chkTeacherInfo.setVisible(true);
				StuMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("查看课程信息");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEntityDAO stuEn = new StudentEntityDAOImpl();
				ArrayList<String[]> class_ = stuEn.fndClsByStuId(stuId);
				String[][] classList = new String[class_.size()][3];
				for (int i = 0; i < class_.size(); i++) {
					classList[i] = class_.get(i);
				}
				ChkCourseInfo cci = new ChkCourseInfo(classList, stuId);
				cci.setVisible(true);
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 75, 330, 345);
		contentPane.add(scrollPane);

		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StudentEntityDAO stuEn = new StudentEntityDAOImpl();
				ArrayList<String[]> a = stuEn.fndAttByStuId(stuId, Integer.parseInt(textField.getText()));
				String[][] b = new String[a.size()][3];
				for (int i = 0; i < a.size(); i++) {
					b[i] = a.get(i);
				}
				String[] cn = { "考勤时间", "课程名称", "考勤状态" };

				table = new JTable(b, cn);
				table.setEnabled(false);
				scrollPane.setViewportView(table);
			}
		});
		button.setBounds(219, 26, 75, 29);
		panel_2.add(button);

	}
}
