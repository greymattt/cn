package dcn_lab;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class serverudp 
{
    public static void main(String args[])
    {
        
        int port = 2222;
        String s;         
        Scanner sc=new Scanner(System.in);   
        try
        {
            DatagramSocket sock = new DatagramSocket();             
            InetAddress host = InetAddress.getByName("localhost");             
            while(true)
            {
                System.out.println("Enter message to send : ");
                s = sc.readLine();
                byte[] b = s.getBytes();                 
                DatagramPacket  dp = new DatagramPacket(b , b.length , host , port);
                sock.send(dp);                 
                byte[] buffer = new byte[65536];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                sock.receive(reply);                 
                byte[] data = reply.getData();
                s = new String(data, 0, reply.getLength());                 
                System.out.println(reply.getAddress().getHostAddress() + " : " + reply.getPort() + " - " + s);
            }
        }         
        catch(Exception e)
        {
            System.err.println("Exception " + e);
        }         
    }   
    
}
