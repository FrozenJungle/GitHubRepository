package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.zzh.bean.StudentEntity;
import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.TeacherEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;
import com.zzh.dao.impl.TeacherEntityDAOImpl;

public class ChkStuInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public ChkStuInfo(int id) {
		super("查看学生信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel np = new JPanel();
		np.setLayout(new FlowLayout());
		contentPane.add(np, BorderLayout.NORTH);

		String[] choice = { "按姓名查询", "按教学班查询", "按学号查询", "按专业查询" };
		JComboBox choose = new JComboBox(choice);
		np.add(choose);

		JLabel label = new JLabel("请输入查询关键字：");
		np.add(label);

		JTextField t = new JTextField();
		np.add(t);
		t.setColumns(10);

		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherEntityDAO teaEn = new TeacherEntityDAOImpl();
				int flag = choose.getSelectedIndex();
				switch (flag) {
				case 0: { // 姓名
					ArrayList<StudentEntity> student = teaEn.fndStuByName(t.getText());
					int length = student.size();
					String[][] studentStr = new String[length][4];
					int i = 0;
					for (StudentEntity studentE : student) {
						studentStr[i][0] = String.valueOf(studentE.getStudent_id());
						studentStr[i][1] = studentE.getStudent_name();
						studentStr[i][2] = studentE.getStudent_college();
						studentStr[i][3] = studentE.getStudent_major();
						i++;
					}

					String[] colunmNames = { "学号", "姓名", "学院", "专业" };
					table = new JTable(studentStr, colunmNames);
					table.setEnabled(false);
					scrollPane.setViewportView(table);
				}
					break;
				case 1: { // 教学班
					ArrayList<StudentEntity> student = teaEn.fndStuByClassId(Integer.parseInt(t.getText()));
					int length = student.size();
					String[][] studentStr = new String[length][4];
					int i = 0;
					for (StudentEntity studentE : student) {
						studentStr[i][0] = String.valueOf(studentE.getStudent_id());
						studentStr[i][1] = studentE.getStudent_name();
						studentStr[i][2] = studentE.getStudent_college();
						studentStr[i][3] = studentE.getStudent_major();
						i++;
					}

					String[] colunmNames = { "学号", "姓名", "学院", "专业" };
					table = new JTable(studentStr, colunmNames);
					table.setEnabled(false);
					scrollPane.setViewportView(table);
				}
					break;
				case 2: {	//学号
					ArrayList<StudentEntity> student = teaEn.fndStuById(Integer.parseInt(t.getText()));
					int length = student.size();
					String[][] studentStr = new String[length][4];
					int i = 0;
					for (StudentEntity studentE : student) {
						studentStr[i][0] = String.valueOf(studentE.getStudent_id());
						studentStr[i][1] = studentE.getStudent_name();
						studentStr[i][2] = studentE.getStudent_college();
						studentStr[i][3] = studentE.getStudent_major();
						i++;
					}

					String[] colunmNames = { "学号", "姓名", "学院", "专业" };
					table = new JTable(studentStr, colunmNames);
					table.setEnabled(false);
					scrollPane.setViewportView(table);
				}
					break;
				case 3: { // 专业
					ArrayList<StudentEntity> student = teaEn.fndStuByMajor(t.getText());
					int length = student.size();
					String[][] studentStr = new String[length][4];
					int i = 0;
					for (StudentEntity studentE : student) {
						studentStr[i][0] = String.valueOf(studentE.getStudent_id());
						studentStr[i][1] = studentE.getStudent_name();
						studentStr[i][2] = studentE.getStudent_college();
						studentStr[i][3] = studentE.getStudent_major();
						i++;
					}

					String[] colunmNames = { "学号", "姓名", "学院", "专业" };
					table = new JTable(studentStr, colunmNames);
					table.setEnabled(false);
					scrollPane.setViewportView(table);
				}
					break;
				}

			}
		});
		np.add(button);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton button_ = new JButton("返回上级菜单");
		button_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkStuInfo.this.dispose();
				TeaMainFrame smf = new TeaMainFrame(id);
				smf.setVisible(true);
			}
		});
		panel.add(button_);
	}

}
