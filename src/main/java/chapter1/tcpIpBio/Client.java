package chapter1.tcpIpBio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args)
			throws UnknownHostException, IOException {
		Socket socket = new Socket("http://localhost", 10000);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println("hello");
		br.readLine();
		socket.close();
	}
}
