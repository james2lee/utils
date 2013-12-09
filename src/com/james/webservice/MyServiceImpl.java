package com.james.webservice;

import javax.jws.WebService;

@WebService(endpointInterface="com.james.webservice.IMyService")
public class MyServiceImpl implements IMyService {

	public MyServiceImpl() {}

	@Override
	public int add(int a, int b) {
		System.out.println(a+"+"+b+"="+(a+b));
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		System.out.println(a+"-"+b+"="+(a-b));
		return a-b;
	}

}
