package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.TeacherEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;
import com.zzh.dao.impl.TeacherEntityDAOImpl;

public class AltTeaPwd extends JFrame {

	private JPanel contentPane;
	private JTextField oldPwd;
	private JTextField newPwd;
	
	public AltTeaPwd(int id) {
		super("修改密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("旧密码：");
		label.setBounds(42, 99, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("新密码：");
		label_1.setBounds(42, 160, 61, 16);
		contentPane.add(label_1);
		
		oldPwd = new JTextField();
		oldPwd.setBounds(127, 94, 130, 26);
		contentPane.add(oldPwd);
		oldPwd.setColumns(10);
		
		newPwd = new JTextField();
		newPwd.setBounds(127, 155, 130, 26);
		contentPane.add(newPwd);
		newPwd.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherEntityDAO teaEn = new TeacherEntityDAOImpl();
				int isSuccess = teaEn.updateTeaPwd(id, oldPwd.getText(), newPwd.getText());
				if(isSuccess==1){
					JOptionPane.showMessageDialog(null, "修改成功！");
					AltTeaPwd.this.dispose();
					TeaMainFrame smf = new TeaMainFrame(id);
					smf.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
			}
		});
		button.setBounds(42, 232, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltTeaPwd.this.dispose();
				TeaMainFrame smf = new TeaMainFrame(id);
				smf.setVisible(true);
			}
		});
		button_1.setBounds(187, 232, 117, 29);
		contentPane.add(button_1);
	}

}
