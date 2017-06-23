package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zzh.bean.StudentEntity;
import com.zzh.bean.TeacherEntity;
import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.TeacherEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;
import com.zzh.dao.impl.TeacherEntityDAOImpl;

public class AltTeaInfo extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField idText;
	private JTextField collegeText;
	private JTextField facText;
	private JTextField emailText;


	public AltTeaInfo(int id) {
		super("修改个人信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		TeacherEntityDAO teaEn = new TeacherEntityDAOImpl();

		JLabel label = new JLabel("姓名：");
		label.setBounds(20, 20, 61, 16);
		contentPane.add(label);

		nameText = new JTextField();
		nameText.setBounds(99, 15, 130, 26);
		contentPane.add(nameText);
		nameText.setColumns(10);

		JLabel label_1 = new JLabel("教师学号：");
		label_1.setBounds(20, 66, 67, 16);
		contentPane.add(label_1);
		
		idText = new JTextField();
		idText.setBounds(99, 61, 130, 26);
		contentPane.add(idText);
		idText.setColumns(10);

		JLabel lblNewLabel = new JLabel("所属学院：");
		lblNewLabel.setBounds(20, 109, 78, 16);
		contentPane.add(lblNewLabel);

//		collegeText = new JTextField();
//		collegeText.setBounds(99, 104, 130, 26);
//		contentPane.add(collegeText);
//		collegeText.setColumns(10);
		
		int length = teaEn.fndAllClg().size();
		String[] allClg = new String[length];
		for(int i=0;i<length;i++){
			allClg[i] = teaEn.fndAllClg().get(i);
		}
		JComboBox clg = new JComboBox(allClg);
		contentPane.add(clg);
		clg.setBounds(99, 104, 130, 26);
		
		

		JLabel label_2 = new JLabel("所属教研室：");
		label_2.setBounds(20, 158, 78, 16);
		contentPane.add(label_2);

//		facText = new JTextField();
//		facText.setBounds(99, 153, 130, 26);
//		contentPane.add(facText);
//		facText.setColumns(10);
		
		
		int length_ = teaEn.fndAllFac().size();
		String[] allFac = new String[length_];
		for(int i=0;i<length_;i++){
			allFac[i] = teaEn.fndAllFac().get(i);
		}
		JComboBox fac = new JComboBox(allFac);
		contentPane.add(fac);
		fac.setBounds(99, 154, 141, 26);

		JLabel lblEmail = new JLabel("E-mail：");
		lblEmail.setBounds(20, 209, 61, 16);
		contentPane.add(lblEmail);

		emailText = new JTextField();
		emailText.setBounds(99, 204, 160, 26);
		contentPane.add(emailText);
		emailText.setColumns(10);

		

		JButton button = new JButton("确定修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherEntityDAO teaEn = new TeacherEntityDAOImpl();
//				nameText;idText;collegeText;facText;emailText;
				String college  = clg.getSelectedItem().toString();
				String faculty  = fac.getSelectedItem().toString();
				String[] eles = {nameText.getText(),idText.getText(),college,faculty,emailText.getText()};
				int isSuccess = teaEn.altTeaInfo(id, eles);
				if (isSuccess == 1) {
					JOptionPane.showMessageDialog(null, "修改成功！");
					AltTeaInfo.this.dispose();
					TeaMainFrame ai = new TeaMainFrame(id);
					ai.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
			}
		});
		button.setBounds(44, 261, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltTeaInfo.this.dispose();
				TeaMainFrame s = new TeaMainFrame(id);
				s.setVisible(true);
			}
		});
		button_1.setBounds(175, 261, 117, 29);
		contentPane.add(button_1);
		
		TeacherEntity te = teaEn.fndTeaById(id);
		nameText.setText(te.getTeacher_name());
		idText.setText(String.valueOf(id));
		//collegeText.setText(te.getCollege_name());
		//facText.setText(te.getFaculty_name());
		emailText.setText(te.getTeacher_email());
		
		JLabel picLabel = new JLabel();
		String picURI = "/images/"+String.valueOf(id+1000)+".png";
		ImageIcon image = new ImageIcon(this.getClass().getResource(picURI));
		image.setImage(image.getImage().getScaledInstance(117, 141, Image.SCALE_SMOOTH));
		picLabel.setIcon(image);
		picLabel.setBounds(233, 20, 117, 141);
		contentPane.add(picLabel);
	}

}
