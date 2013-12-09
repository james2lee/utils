package com.james.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class TestClient {
	public static void main(String[] args) {
		try {
			//创建访问wsdl服务地址的url
			URL url = new URL("http://localhost:44444/ns?wsdl");
			//通过QName指明服务的具体信息
			QName serviceName = new QName("http://webservice.james.com/","MyServiceImplService");
			//创建服务
			Service service = Service.create(url, serviceName);
			//实现接口
			IMyService iMyService = service.getPort(IMyService.class);
			//上面的服务有问题，依然依赖于IMyService接口
			System.out.println(iMyService.add(22, 34));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
