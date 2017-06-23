package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class StuLoginFrame extends JFrame {

	static final int DEFAULT_WIDTH = 300;
	static final int DEFAULT_HEIGHT = 300;

	public StuLoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("学生登录");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeigthpx = screenSize.height;
		setLocation(screenWidthpx / 3, screenHeigthpx / 3);
		setLocationByPlatform(false);
		StuLoginPanel loginPanel = new StuLoginPanel();
		setContentPane(loginPanel);
		setVisible(true);
		setResizable(false);

	}

	class StuLoginPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public StuLoginPanel() {
			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(new BorderLayout(0, 0));
			JPanel buttonPanel = new JPanel();
			JPanel infoPanel = new JPanel();
			JLabel picLabel = new JLabel();
			JLabel idLabel = new JLabel("学生ID：");
			JLabel pwdLabel = new JLabel("密    码：");
			JPasswordField pwdTextField = new JPasswordField();
			JTextField idTextField = new JTextField();
			JButton okButton = new JButton("登录");
			JButton clearButton = new JButton("清空");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentEntityDAO stuEn = new StudentEntityDAOImpl();
					if ((stuEn.login(Integer.parseInt(idTextField.getText()),
							new String(pwdTextField.getPassword()))) != null) {
						JOptionPane.showMessageDialog(null, "登录成功！");
						StuLoginFrame.this.dispose();
						StuMainFrame smf = new StuMainFrame(Integer.parseInt(idTextField.getText()));
						smf.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "登录失败！");
					}

				}
			});

			clearButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idTextField.setText("");
					pwdTextField.setText("");
				}
			});

			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT / 2);

			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/login_.jpg"));
			image.setImage(
					image.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_SMOOTH));
			picLabel.setIcon(image);
			infoPanel.add(picLabel);
			infoPanel.add(idLabel);
			infoPanel.add(idTextField);
			infoPanel.add(pwdLabel);
			infoPanel.add(pwdTextField);
			buttonPanel.add(okButton);
			buttonPanel.add(clearButton);

			add(buttonPanel, BorderLayout.SOUTH);
			add(infoPanel, BorderLayout.CENTER);
			idTextField.setColumns(15);
			pwdTextField.setColumns(15);

		}

	}

}
