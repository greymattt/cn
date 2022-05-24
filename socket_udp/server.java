package dcn_lab;

import java.net.*;
import java.io.*;
public class clientudp
{
    public static void main(String args[])
    {
        try
        {
            DatagramSocket sock = new DatagramSocket(2222);
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            System.out.println("Server socket created. Waiting for incoming data...");             
            while(true)
            {
                sock.receive(incoming);
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());
                System.out.println(incoming.getAddress().getHostAddress() + " : " + incoming.getPort() + " - " + s);   
                s = "OK : " + s;
                DatagramPacket dp = new DatagramPacket(s.getBytes() , s.getBytes().length ,incoming.getAddress(), incoming.getPort());
                sock.send(dp);
            }
        }         
        catch(Exception e)
        {
            System.err.println("Exception " + e);
        }
    }   
}
