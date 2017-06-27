package control;

import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import model.ChatUIMap;
import net.Client;
import ui.ChatUI;
import util.Parser;
import util.Time;

public class ChatRcvThread extends Thread {

	public void run() {

		for (;;) {
			String receiveStr = Client.read();
			if (!receiveStr.equals(null)) {
				Parser parser = new Parser();
				String[] parsedStrs = parser.getChatMessage(receiveStr);
				String fromWhom = parsedStrs[0];
				String toWhom = parsedStrs[1];
				String content = parsedStrs[2];
				ChatUI chatui = (ChatUI) ChatUIMap.getChatUIMap().get(fromWhom + "," + toWhom);
				System.out.println(chatui);

				// 如果之前没有与对方的聊天窗口就new一个新的，否则...
				if (chatui == null) {
					ChatUI chatui1 = new ChatUI(Integer.parseInt(toWhom), Integer.parseInt(fromWhom), content);
					ChatUIMap.getChatUIMap().put(fromWhom + "," + toWhom, chatui1);
					ChatUIMap.getChatUIMap().put(toWhom + "," + fromWhom, chatui1);
					chatui1.setVisible(true);
				} else {
					chatui._dispose();
					Document doc = chatui.getDoc();
					Time time = new Time();
					try {
						String currentText = doc.getText(0, doc.getLength());
						String readIn = fromWhom.toString() + "(" + time.getHMS() + ")\n" + content + "\n";
						currentText += readIn;
						ChatUI cu = new ChatUI(Integer.parseInt(toWhom), Integer.parseInt(fromWhom), currentText);
						cu.getShowText().setText(currentText);
						ChatUIMap.getChatUIMap().put(fromWhom + "," + toWhom, cu);
						ChatUIMap.getChatUIMap().put(toWhom + "," + fromWhom, cu);

						cu.setVisible(true);
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
