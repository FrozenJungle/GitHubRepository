package control;

import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {

	public boolean login(int userId, String password) {
		Protocol protocol = new Protocol();
		String msg = protocol.getLoginMsg(userId, password); // 打包查询语句
		Client.write(msg); // 发送信息给服务器，服务器处理请求
		String returnStr = Client.read();
		System.out.println("returnStr:" + returnStr);
		Parser parser = new Parser();
		boolean isSuccess = parser.getIsSuccess(returnStr);
		return isSuccess;
	}

	public void chat(int fromWhom, int toWhom, String content) {
		Protocol protocol = new Protocol();
		String msg = protocol.getChatMsg(fromWhom, toWhom, content);
		System.out.println("msg:" + msg);
		// 最终发送的String只能有一个\n，这里不加\n，否则readLine下一次读取也为空
		Client.write(msg);

	}

	public void chatRcvListen() {

		ChatRcvThread chatRcvThread = new ChatRcvThread();
		chatRcvThread.start();

	}
}
