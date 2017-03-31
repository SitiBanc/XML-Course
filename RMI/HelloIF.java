//
//Step 1. Create Interface
//
//Note: interface must extend java.rmi.Remote
//

public interface HelloIF extends java.rmi.Remote{
	//the single method to be implemented
	public String getHello()
		throws java.rmi.RemoteException;
}