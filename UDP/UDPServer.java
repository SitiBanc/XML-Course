import java.net.*;
import java.io.*;
import java.util.*;
public class UDPServer{
	public static void main(String args[]){ 
		try{
			DatagramSocket aSocket = new DatagramSocket(6789);
			byte[] buffer = new byte[1000];
			byte[] systemdate;
			while(true){
				Date sdate = new Date();
				String system_date = sdate.toString();
				systemdate=system_date.getBytes();
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);     
				DatagramPacket reply = new DatagramPacket(systemdate, systemdate.length, request.getAddress(), request.getPort());
				aSocket.send(reply);
			}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());}
	}
}
