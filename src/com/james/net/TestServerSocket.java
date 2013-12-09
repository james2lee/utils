package com.james.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerSocket {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(44444);
			System.out.println("服务器启动：" + serverSocket.getInetAddress().getHostAddress()+" : "+serverSocket.getLocalPort());
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("客户端连接： "+socket.getInetAddress().getHostAddress()+" : "+socket.getPort());
				BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter os = new PrintWriter(socket.getOutputStream());
				
				String line;
				while ((line = is.readLine()) != null) {
					System.out.println("收到： "+line);
					if (line.equals("bye")) {
						break;
					}else {
						os.println(sin.readLine());
						os.flush();
					}
				}
				is.close();
				os.close();
				sin.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
