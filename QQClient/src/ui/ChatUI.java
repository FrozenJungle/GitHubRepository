package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

import control.Operator;
import model.ChatUIMap;
import net.Client;
import util.Time;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatUI extends JFrame {

	private JPanel contentPane;
	Document doc;
	JTextPane showText;

	public void _dispose() {
		ChatUI.this.dispose();
	}

	public Document getDoc() {
		return doc;
	}

	public JTextPane getShowText() {
		return showText;
	}

	public ChatUI(Integer fromWhom, Integer toWhom) {
		// TODO 发送消息UI，无content的构造函数

		String key = fromWhom + "," + toWhom;
		ChatUIMap.getChatUIMap().put(key, this);
		ChatUIMap.getChatUIMap().put(toWhom + "," + fromWhom, this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ChatUIMap.getChatUIMap().remove(key);
				ChatUIMap.getChatUIMap().remove(toWhom + "," + fromWhom);

			}
		});

		JPanel panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);

		JLabel lblQq = new JLabel("正在与" + toWhom + "聊天...");
		lblQq.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panel_north.add(lblQq);

		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));

		showText = new JTextPane();
		showText.setFont(new Font("PingFang SC", Font.PLAIN, 15));
		showText.setEditable(false);
		JScrollPane scrollPane_center_center = new JScrollPane(showText);
		panel_center.add(scrollPane_center_center, BorderLayout.CENTER);

		JTextPane typeInText = new JTextPane();
		typeInText.setFont(new Font("PingFang SC", Font.PLAIN, 14));

		JScrollPane scrollPane_center_south = new JScrollPane(typeInText);
		panel_center.add(scrollPane_center_south, BorderLayout.SOUTH);
		scrollPane_center_south.setPreferredSize(new Dimension(0, 100));

		JPanel panel_east = new JPanel();
		contentPane.add(panel_east, BorderLayout.EAST);
		panel_east.setLayout(new BorderLayout(0, 0));
		panel_east.setPreferredSize(new Dimension(100, 100));

		JPanel panel_east_south = new JPanel();
		panel_east.add(panel_east_south, BorderLayout.SOUTH);
		panel_east_south.setPreferredSize(new Dimension(0, 100));
		panel_east_south.setLayout(new BorderLayout(0, 0));

		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String typeIn = typeInText.getText() + "\n";
				doc = showText.getDocument();
				try {
					Operator operator = new Operator();
					Time time = new Time();
					operator.chat(fromWhom, toWhom, typeIn);
					String currentText = doc.getText(0, doc.getLength());
					String typeFinal = fromWhom.toString() + "(" + time.getHMS() + ")\n" + typeIn;
					currentText += typeFinal;
					showText.setText(currentText);
					typeInText.setText(null);
					typeInText.requestFocus();
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}

		});
		panel_east_south.add(button);

	}

	public ChatUI(Integer fromWhom, Integer toWhom, String content) {
		// TODO 重载构造函数：有content的构造函数
		// 如果已经有与对方的聊天窗口？——
		// 用HashMap存ui界面和双方id构造的String，每次new新界面前判断是否已经存在，这个HashMap由MainUI维护

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				String key = fromWhom + "," + toWhom;
				ChatUIMap.getChatUIMap().remove(key);
				ChatUIMap.getChatUIMap().remove(toWhom + "," + fromWhom);
			}
		});

		JPanel panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);

		JLabel lblQq = new JLabel("正在与" + toWhom + "聊天...");
		lblQq.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panel_north.add(lblQq);

		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));

		showText = new JTextPane();
		showText.setFont(new Font("PingFang SC", Font.PLAIN, 15));
		showText.setEditable(false);
		JScrollPane scrollPane_center_center = new JScrollPane(showText);
		panel_center.add(scrollPane_center_center, BorderLayout.CENTER);

		JTextPane typeInText = new JTextPane();
		typeInText.setFont(new Font("PingFang SC", Font.PLAIN, 14));

		doc = showText.getDocument();
		Time time = new Time();
		String currentText1;
		try {
			currentText1 = doc.getText(0, doc.getLength());
			String readIn = toWhom.toString() + "(" + time.getHMS() + ")\n" + content + "\n";
			currentText1 += readIn;
			showText.setText(currentText1);
			typeInText.setText(null);
			typeInText.requestFocus();
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}

		// 键盘监听
		// typeInText.addKeyListener(new KeyAdapter() {
		// public void keyPressed(KeyEvent e) {
		// String typeIn = typeInText.getText() + "\n";
		// Document doc = showText.getDocument();
		// try {
		// String currentText = doc.getText(0, doc.getLength());
		// currentText += typeIn;
		// if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isShiftDown()) {
		// showText.setText(currentText);
		// typeInText.setText(null);
		// }
		//
		// } catch (BadLocationException e1) {
		// e1.printStackTrace();
		// }
		// }
		// });

		JScrollPane scrollPane_center_south = new JScrollPane(typeInText);
		panel_center.add(scrollPane_center_south, BorderLayout.SOUTH);
		scrollPane_center_south.setPreferredSize(new Dimension(0, 100));

		JPanel panel_east = new JPanel();
		contentPane.add(panel_east, BorderLayout.EAST);
		panel_east.setLayout(new BorderLayout(0, 0));
		panel_east.setPreferredSize(new Dimension(100, 100));

		JPanel panel_east_south = new JPanel();
		panel_east.add(panel_east_south, BorderLayout.SOUTH);
		panel_east_south.setPreferredSize(new Dimension(0, 100));
		panel_east_south.setLayout(new BorderLayout(0, 0));

		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String typeIn = typeInText.getText() + "\n";
				doc = showText.getDocument();
				try {

					Operator operator = new Operator();
					Time time = new Time();
					operator.chat(fromWhom, toWhom, typeIn);
					String currentText = doc.getText(0, doc.getLength());
					String typeFinal = fromWhom.toString() + "(" + time.getHMS() + ")\n" + typeIn;
					currentText += typeFinal;
					showText.setText(currentText);
					typeInText.setText(null);
					typeInText.requestFocus();

				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_east_south.add(button);

	}

}
