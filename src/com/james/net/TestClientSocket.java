package com.james.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClientSocket {
	public static void main(String[] args) {
		try {
			Socket socket= new Socket("localhost", 44444);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			String readString;
			while ((readString = sin.readLine()) != null) {
				os.println(readString);
				os.flush();
				String responseline = is.readLine();
				System.out.println("收到回复： "+responseline);
			}
			is.close();
			os.close();
			sin.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
