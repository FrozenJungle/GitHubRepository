package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Operator;
import model.ChatUIMap;
import net.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class MainUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField toWhomText;

	public MainUI(Integer userId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(950, 100, 200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				Client.write("0\n");
			}
		});

		JPanel panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new BorderLayout(0, 0));

		JLabel lblQq = new JLabel("QQ");
		lblQq.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblQq.setHorizontalAlignment(SwingConstants.CENTER);
		panel_north.add(lblQq, BorderLayout.CENTER);

		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(null);

		JLabel label = new JLabel("想和谁聊：");
		label.setFont(new Font("PingFang SC", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(31, 107, 90, 16);
		panel_center.add(label);

		toWhomText = new JTextField();
		toWhomText.setBounds(31, 157, 130, 26);
		panel_center.add(toWhomText);
		toWhomText.setColumns(10);

		JButton button_yes = new JButton("确定");
		button_yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatUI chatui = new ChatUI(userId, Integer.parseInt(toWhomText.getText()));
				ChatUIMap.getChatUIMap().put(userId.toString() + "," + toWhomText.getText(), chatui);
				ChatUIMap.getChatUIMap().put(toWhomText.getText() + "," + userId.toString(), chatui);
				chatui.setVisible(true);
			}
		});
		button_yes.setBounds(44, 219, 117, 29);
		panel_center.add(button_yes);

//		button_yes.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				ChatUI chatui = new ChatUI(userId, Integer.parseInt(toWhomText.getText()));
//				ChatUIMap.getChatUIMap().put(userId.toString() + "," + toWhomText.getText(), chatui);
//				ChatUIMap.getChatUIMap().put(toWhomText.getText() + "," + userId.toString(), chatui);
//				chatui.setVisible(true);
//			}
//		});

//		toWhomText.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				ChatUI chatui = new ChatUI(userId, Integer.parseInt(toWhomText.getText()));
//				ChatUIMap.getChatUIMap().put(userId.toString() + "," + toWhomText.getText(), chatui);
//				ChatUIMap.getChatUIMap().put(toWhomText.getText() + "," + userId.toString(), chatui);
//				chatui.setVisible(true);
//			}
//		});

		JLabel label_1 = new JLabel("欢迎你，");
		label_1.setFont(new Font("PingFang SC", Font.PLAIN, 16));
		label_1.setBounds(31, 24, 130, 26);
		panel_center.add(label_1);

		JLabel lblNewLabel = new JLabel(userId.toString());
		lblNewLabel.setBounds(31, 62, 130, 16);
		panel_center.add(lblNewLabel);

		// 接收消息监听
		Operator operator = new Operator();
		operator.chatRcvListen();
	}

}
