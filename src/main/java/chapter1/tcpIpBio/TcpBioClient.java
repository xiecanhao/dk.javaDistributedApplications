package chapter1.tcpIpBio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpBioClient {
	public static void main(String[] args)
			throws UnknownHostException, IOException {
		// 创建连接，如果域名解析不了会抛出UnknownHostException，当连接不上时会抛出IOException，如果希望控制简历连接超时，可以先调用new
		// Socket(),然后调用socket.connect(SocketAddress类型的目标地址，以毫秒为单位的超时时间)
		Socket socket = new Socket("localhost", 10000);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		// 想服务器发送字符串信息，要注意的是，此处即使写失败也不会抛出异常信息，并且一直会阻塞到写入操作系统或网络io出现异常为止。可设置阻塞超时时间socket.setSoTimeout(以毫秒为单位的超时时间);
		out.println("hello");
		String str = br.readLine();
		System.out.println(str);
		socket.close();
	}
}
