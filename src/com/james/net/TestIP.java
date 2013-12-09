package com.james.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIP {
	public static void main(String[] args) {
		try {
			InetAddress[] address = InetAddress.getAllByName("www.taobao.com");
			for (InetAddress inetAddress : address) {
				System.out.println(inetAddress+"  HostName: "+inetAddress.getHostName()+"    HostAddress: "+inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
