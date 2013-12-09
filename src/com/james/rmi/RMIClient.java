package com.james.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class RMIClient {

	public static void main(String[] args) {
		//创建并安装安全管理器
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		
		try {
			IHelloWorld hello = (IHelloWorld) Naming.lookup("rmi://localhost:1099/HelloWorldService");
			System.out.println(hello.sayHello("你好"));
			System.out.println("China");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
