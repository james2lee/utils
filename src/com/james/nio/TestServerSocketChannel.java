package com.james.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

public class TestServerSocketChannel {
	public static void main(String[] args) {
		Selector selector = null;
		ServerSocketChannel server = null;
		try {
			//创建一个Selector
			selector = Selector.open();
			//创建ServerSocketChannel并注册
			server = ServerSocketChannel.open();
			server.configureBlocking(false);
			server.register(selector, SelectionKey.OP_ACCEPT);
			
			//启动监听端口
			InetSocketAddress ip = new InetSocketAddress("localhost",44444);
			server.socket().bind(ip);
			
			//监听事件
			while (true) {
				selector.select();
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					//删除当前事件
					it.remove();
					//判断事件类型
					if (key.isConnectable()) {
						//连接事件
						SocketChannel channel = (SocketChannel) key.channel();
						channel.register(selector, SelectionKey.OP_CONNECT);
					}else if (key.isReadable()) {
						//读取事件
						SocketChannel channel = (SocketChannel) key.channel();
						channel.register(selector, SelectionKey.OP_WRITE);
						//读取数据
						CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						int count = channel.read(buffer);
						System.out.println(count+""+decoder.decode(buffer));;
					}else if (key.isWritable()) {
						//写入事件
						SocketChannel channel = (SocketChannel) key.channel();
						channel.register(selector, SelectionKey.OP_WRITE);
						//写入数据
						CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
						channel.write(encoder.encode(CharBuffer.wrap("hello")));
					}
					
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
