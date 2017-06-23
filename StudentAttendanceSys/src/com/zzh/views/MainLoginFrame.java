package com.zzh.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zzh.dao.StudentEntityDAO;
import com.zzh.dao.impl.StudentEntityDAOImpl;
import com.zzh.views.StuLoginFrame.StuLoginPanel;

public class MainLoginFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static final int DEFAULT_WIDTH = 300;
	static final int DEFAULT_HEIGHT = 300;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLoginFrame frame = new MainLoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainLoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("选择登录角色");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidthpx = screenSize.width;
		int screenHeigthpx = screenSize.height;
		setLocation(screenWidthpx / 3, screenHeigthpx / 3);
		setLocationByPlatform(false);
		LoginPanel loginPanel = new LoginPanel();
		setContentPane(loginPanel);
		setVisible(true);
		setResizable(false);
	}

	class LoginPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public LoginPanel() {
			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(new BorderLayout(0, 0));
			JPanel buttonPanel = new JPanel();
			JPanel infoPanel = new JPanel();
			JLabel infoLabel = new JLabel("欢迎来到考勤管理系统！");
			infoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			JLabel picLabel = new JLabel();
			JButton stuButton = new JButton("我是学生");
			stuButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainLoginFrame.this.dispose();
					StuLoginFrame slf = new StuLoginFrame();
					slf.setVisible(true);
				}
			});
			JButton teaButton = new JButton("我是教师");
			teaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainLoginFrame.this.dispose();
					TeaLoginFrame tlf = new TeaLoginFrame();
					tlf.setVisible(true);
				}
			});

			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT / 2);

			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/login_.jpg"));
			image.setImage(
					image.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_SMOOTH));
			picLabel.setIcon(image);
			infoPanel.add(picLabel);
			infoPanel.add(infoLabel);
			buttonPanel.add(stuButton);
			buttonPanel.add(teaButton);

			add(buttonPanel, BorderLayout.SOUTH);
			add(infoPanel, BorderLayout.CENTER);

		}

	}

}
