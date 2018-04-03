package mytest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class TestServerSocketChannel {
	private static Selector selector = null;

	public static void main(String[] args) throws IOException {
		selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(10000));
		ssc.configureBlocking(false);
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		ssc.accept();
		while (true) {
			selector.select(20000);
			selector.selectedKeys();
		}
	}
}
