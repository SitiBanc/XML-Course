//
//Step 3. Create client
//

import java.rmi.*;

public class HelloClient{
	public static void main(String args[]){
		String message = "Hi";
		
		try{
			HelloIF obj = (HelloIF) Naming.lookup("rmi://192.168.1.32/HelloService");
			message = obj.getHello();
			System.out.println(message);
		}catch (Exception e){
			System.out.println("HelloService exception:" + e.getMessage());
			e.printStackTrace();
		}
	}
}