package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltEmail extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton button_1;

	/**
	 * Create the frame.
	 */
	public AltEmail(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblemail = new JLabel("新Email：");
		lblemail.setBounds(88, 118, 61, 16);
		contentPane.add(lblemail);

		textField = new JTextField();
		textField.setBounds(207, 113, 130, 26);
		contentPane.add(textField);
		textField.setColumns(20);

		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEntityDAO stuEn = new StudentEntityDAOImpl();
				int isSuccess = stuEn.updateStuEmail(id, textField.getText());
				if (isSuccess == 1) {
					JOptionPane.showMessageDialog(null, "修改成功！");
					AltEmail.this.dispose();
					AltInfo ai = new AltInfo(id);
					ai.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
			}
		});
		button.setBounds(88, 194, 117, 29);
		contentPane.add(button);
		
		button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltEmail.this.dispose();
				AltInfo ai = new AltInfo(id);
				ai.setVisible(true);
			}
		});
		button_1.setBounds(238, 194, 117, 29);
		contentPane.add(button_1);
	}

}
