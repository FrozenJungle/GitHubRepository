package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zzh.bean.StudentEntity;
import com.zzh.bean.TeacherEntity;
import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.TeacherEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;
import com.zzh.dao.impl.TeacherEntityDAOImpl;

public class ChkTeaInfo extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField idText;
	private JTextField collegeText;
	private JTextField facText;
	private JTextField emailText;

	public ChkTeaInfo(int id) {
		super("查看个人信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//姓名，教师学号，归属学院，归属教研室，电子 邮件
		

		JLabel label = new JLabel("姓名：");
		label.setBounds(20, 20, 61, 16);
		contentPane.add(label);

		nameText = new JTextField();
		nameText.setEditable(false);
		nameText.setBounds(93, 15, 130, 26);
		contentPane.add(nameText);
		nameText.setColumns(10);

		JLabel label_1 = new JLabel("教师学号：");
		label_1.setBounds(20, 66, 65, 16);
		contentPane.add(label_1);

		JLabel lblNewLabel = new JLabel("所属学院：");
		lblNewLabel.setBounds(20, 109, 65, 16);
		contentPane.add(lblNewLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(93, 61, 130, 26);
		contentPane.add(idText);
		idText.setColumns(10);

		collegeText = new JTextField();
		collegeText.setEditable(false);
		collegeText.setBounds(93, 104, 130, 26);
		contentPane.add(collegeText);
		collegeText.setColumns(10);

		JLabel label_2 = new JLabel("所属教研室：");
		label_2.setBounds(20, 158, 78, 16);
		contentPane.add(label_2);

		facText = new JTextField();
		facText.setEditable(false);
		facText.setBounds(93, 153, 130, 26);
		contentPane.add(facText);
		facText.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail：");
		lblEmail.setBounds(20, 209, 61, 16);
		contentPane.add(lblEmail);

		emailText = new JTextField();
		emailText.setEditable(false);
		emailText.setBounds(93, 204, 160, 26);
		contentPane.add(emailText);
		emailText.setColumns(10);

		

		JButton button_1 = new JButton("确定");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChkTeaInfo.this.dispose();
				TeaMainFrame t = new TeaMainFrame(id);
				t.setVisible(true);

			}
		});
		button_1.setBounds(118, 261, 117, 29);
		contentPane.add(button_1);
		
		TeacherEntityDAO teaEn = new TeacherEntityDAOImpl();
		TeacherEntity te = teaEn.fndTeaById(id);
		nameText.setText(te.getTeacher_name());
		idText.setText(String.valueOf(id));
		collegeText.setText(te.getCollege_name());
		facText.setText(te.getFaculty_name());
		emailText.setText(te.getTeacher_email());
		
		JLabel picLabel = new JLabel();
		String picURI = "/images/"+String.valueOf(id+1000)+".png";
		ImageIcon image = new ImageIcon(this.getClass().getResource(picURI));
		image.setImage(image.getImage().getScaledInstance(117, 141, Image.SCALE_SMOOTH));
		picLabel.setIcon(image);
		picLabel.setBounds(227, 20, 117, 141);
		contentPane.add(picLabel);
	}

}
