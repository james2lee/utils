package com.james.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorld extends UnicastRemoteObject implements IHelloWorld {

	private static final long serialVersionUID = 1L;

	protected HelloWorld() throws RemoteException {
		super();
		
	}

	@Override
	public String sayHello(String world) throws RemoteException {
		return "Hello "+world+"!";
	}

}
