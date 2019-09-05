package client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        System.out.println("Client started");

        try {
                Socket soc = new Socket("localhost",9999); // localhost -> (IP address of our server) cuz both client and server
                // are on same machine localhost= IP add of our system = 127.0.0.1
                // port no -> 2nd arg
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                // System.in -> takes only bytewise ip from user i.e deals with byte input format
                // InputStreamReader -> converts those bytewise ip to stream of characters
                // BufferedReader -> those stream of characters can be now used as a string ip
                System.out.println("Enter a number");
                int num = Integer.parseInt(userInput.readLine());

                PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
                out.println(num); // send the string read from user(str) to server
                // PrintWriter object is used to get OutputStream so that we can send msgs to server
                // PrintWriter obj has the habit to keep the stream to itself so if we do not write autoflush=true
                // it will not send the string to server. To send the data we have to flush the obj only then it will send
                // that string

                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                // to read the string sent from server
                System.out.println(in.readLine());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
