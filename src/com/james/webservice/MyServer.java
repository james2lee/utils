package com.james.webservice;

import javax.xml.ws.Endpoint;

public class MyServer {
	public static void main(String[] args) {
		//提供服务的地址
		String address = "http://localhost:44444/ns";
		//发布WebService
		Endpoint.publish(address,new MyServiceImpl());
	}
}
