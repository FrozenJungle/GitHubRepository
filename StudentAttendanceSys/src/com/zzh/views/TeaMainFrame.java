package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.zzh.bean.StudentEntity;
import com.zzh.bean.TeacherEntity;
import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.TeacherEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;
import com.zzh.dao.impl.TeacherEntityDAOImpl;

public class TeaMainFrame extends JFrame {

	private JPanel contentPane;

	public TeaMainFrame(int id) {
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

		JLabel idLabel = new JLabel(String.valueOf(id));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(0, 142, 150, 23);
		panel.add(idLabel);

		JLabel picLabel = new JLabel();
		String picURI = "/images/" + String.valueOf(id+1000) + ".png";
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
				ChkTeaInfo cti = new ChkTeaInfo(id);
				cti.setVisible(true);
				TeaMainFrame.this.dispose();

			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("修改个人信息");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltTeaInfo ati = new AltTeaInfo(id);
				ati.setVisible(true);
				TeaMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改个人密码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltTeaPwd altPwd = new AltTeaPwd(id);
				altPwd.setVisible(true);
				TeaMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("查看学生信息");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChkStuInfo chkStuInfo = new ChkStuInfo(id);
				chkStuInfo.setVisible(true);
				TeaMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_3);

		
		//下面还没实现
		JButton btnNewButton_4 = new JButton("查看考勤记录");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherEntityDAO teaEn = new TeacherEntityDAOImpl();
				ArrayList<String[]> allAtt = teaEn.fndAllAtt(id);
				String[][] att = new String[allAtt.size()][6];
				for(int i=0;i<allAtt.size();i++){
					att[i]=allAtt.get(i);
				}
				ChkAttInfo cai = new ChkAttInfo(att,id);
				cai.setVisible(true);
				TeaMainFrame.this.dispose();
			}
		});
		panel_1.add(btnNewButton_4);
		
//		JButton btnNewButton_5 = new JButton("录入考勤信息");
//		btnNewButton_5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				TeaMainFrame.this.dispose();
//			}
//		});
//		panel_1.add(btnNewButton_5);

		

	}

}
