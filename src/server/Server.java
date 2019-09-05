package server;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
    	ServerSocket server = new ServerSocket(9999);
		Socket s = server.accept();
		
	            
	            System.out.println("Just connected to " + s.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(s.getInputStream());
	            
	            System.out.println(in.readUTF());
	            System.out.println(in.readUTF());
	            String i="0";
	            while(!i.equals("1")) {
		            System.out.println(in.readUTF());
		            i = in.readUTF();
	               

	                
	        	}
	       

	            DataOutputStream out = new DataOutputStream(s.getOutputStream());
	            out.writeUTF("Thank you for connecting to " + s.getLocalSocketAddress()
	               + "\nGoodbye!");
	            s.close();
		
		
	}
}

    

  