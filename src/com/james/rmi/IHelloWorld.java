package com.james.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloWorld extends Remote{
	public String sayHello(String world) throws RemoteException;
}
