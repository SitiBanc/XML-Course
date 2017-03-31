//
//Step 2. Create Interface Implementation
//

import java.rmi.*;
import java.rmi.server.*;
//import java.util.*;

public class HelloImpl extends UnicastRemoteObject implements HelloIF{
	private String serviceName;
	
	public HelloImpl(String s) throws RemoteException{
		super();
		serviceName = s;
	}
	
	public String getHello() throws RemoteException{
		String HelloStr = "Hello World";
		return HelloStr;
	}
	//嘗試回傳系統時間
	/*
	public String getTime() throws RemoteException{
		Date sdate = new Date();
		return sdate.toString();
	}
	*/
	
	public static void main(String args[]){
		System.setSecurityManager(new RMISecurityManager());
		
		//Registration
		try{
			HelloImpl obj = new HelloImpl("HelloService");
			Naming.rebind("//192.168.1.32/HelloService",obj);
			System.out.println("HelloService registered.");
		}catch (Exception e){
			System.out.println("HelloImpl Err:" + e.getMessage());
			e.printStackTrace();
		}
	}
}