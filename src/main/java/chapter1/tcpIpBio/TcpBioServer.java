package chapter1.tcpIpBio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpBioServer {
	public static void main(String[] args) throws IOException {
		// 创建本地指定端口的监听，如果端口冲突则抛出SocketException，其他网络io方面的异常则抛出IOException
		ServerSocket ss = new ServerSocket(10000);
		System.out.println("监听10000端口");
		Socket socket = ss.accept();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		String line = null;
		if ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		// 写回数据
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		bw.write("holle client");
		bw.flush();
		socket.close();
		ss.close();
	}
}
