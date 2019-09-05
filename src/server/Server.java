package server;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Waiting for client .......");

        try
        {
            ServerSocket ss = new ServerSocket(9999); // port no of our server to identify our application on network
            // IP address identifies ur machine but machine can have multiple applications so port no identifies 1 of those application
            // so this object 'ss' is now bound to this port no

            Socket soc = ss.accept(); // wait for incoming socket connection requests to Server

            System.out.println("Connection established");

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            // unlike Client here we have to read the string from socket's InputStream and not the
            // System's InputStream i.e keyboard so we did not write System.in here
            int num = Integer.parseInt(in.readLine());
            System.out.println(num);
            PrintWriter out = new PrintWriter(soc.getOutputStream(),true); // sending the ip read from client
            // back to client (echo)
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

    

  