package client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws UnknownHostException, IOException {
		String ip="localhost";
		int port = 9999;
		Socket s = new Socket(ip,port);
        System.out.println("Just connected to " + s.getRemoteSocketAddress());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("Hello from " + s.getLocalSocketAddress());
        out.writeUTF("again");
        String i="0";
        while(!i.equals("1")) {
        System.out.println("Enter a message");
        String str = scan.next();
        out.writeUTF(str);
        System.out.println("Enter 1 to exit");
        i = scan.next();
        out.writeUTF(i);

        
	}

        
        InputStream inFromServer = s.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        
        System.out.println("Server says " + in.readUTF());
        s.close();
  


	}
}
