package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Operator;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 275, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_main = new JPanel();
		contentPane.add(panel_main, BorderLayout.CENTER);

		JPanel panel_title = new JPanel();
		contentPane.add(panel_title, BorderLayout.NORTH);

		JPanel panel_button = new JPanel();
		contentPane.add(panel_button, BorderLayout.SOUTH);

		JLabel label_title = new JLabel();
		label_title.setFont(new Font("PingFang SC", Font.PLAIN, 18));
		label_title.setText("欢迎登陆QQ!");
		panel_title.add(label_title);
		panel_main.setLayout(null);

		JLabel label_un = new JLabel();
		label_un.setBounds(107, 34, 56, 20);
		label_un.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		label_un.setText("用户名：");
		panel_main.add(label_un);

		JTextField text_un = new JTextField();
		text_un.setBounds(220, 31, 130, 26);
		text_un.setColumns(10);
		panel_main.add(text_un);

		JLabel label_pw = new JLabel();
		label_pw.setBounds(121, 117, 42, 20);
		label_pw.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		label_pw.setText("密码：");
		panel_main.add(label_pw);

		JPasswordField text_pw = new JPasswordField();
		text_pw.setBounds(220, 114, 130, 26);
		text_pw.setColumns(10);
		panel_main.add(text_pw);

		JButton login_button = new JButton();
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = Integer.parseInt(text_un.getText());
				String password = String.valueOf(text_pw.getPassword());
				Operator operator = new Operator();
				boolean isSuccess = operator.login(userId, password);
				if (isSuccess) {
					MainUI mainui = new MainUI(userId);
					mainui.setVisible(true);
					LoginUI.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "登录失败！");
				}
			}
		});
		login_button.setText("登录");
		login_button.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		panel_button.add(login_button);

		login_button.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int userId = Integer.parseInt(text_un.getText());
					String password = String.valueOf(text_pw.getPassword());
					Operator operator = new Operator();
					boolean isSuccess = operator.login(userId, password);
					if (isSuccess) {
						MainUI mainui = new MainUI(userId);
						mainui.setVisible(true);
						LoginUI.this.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "登录失败！");
					}
				}
			}
		});

		text_pw.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int userId = Integer.parseInt(text_un.getText());
					String password = String.valueOf(text_pw.getPassword());
					Operator operator = new Operator();
					boolean isSuccess = operator.login(userId, password);
					if (isSuccess) {
						MainUI mainui = new MainUI(userId);
						mainui.setVisible(true);
						LoginUI.this.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "登录失败！");
					}
				}
			}
		});

		JButton signin_button = new JButton();
		signin_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signin_button.setText("注册");
		signin_button.setFont(new Font("PingFang SC", Font.PLAIN, 14));
		panel_button.add(signin_button);
	}
}
