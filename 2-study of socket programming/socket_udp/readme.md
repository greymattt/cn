# algorithm
## CLIENT:
Step 01: Start the program.  
Step 02: Create a socket with port number and inet address.  
Step 03: Get the input from the user using Socket class.  
Step 04: Write the same to server using Datagram Socket class.  
Step 05: Read the data from the server and print the same on the console output.  
Step 06: Repeat the same until the user wants to quit.  
Step 07: End the program.   

## SERVER:

Step 01: Start the program.  
Step 02: Establish a socket of ServerSocket type.  
Step 03: Accept the connection from the client.  
Step 04: Read the input from the client and print the same on the console output.  
Step 05: Pass the same data to the client using Datagram Socket class.  
Step 06: Repeat the same until the user wants to quit.  
Step 07: End the program.  

# program
## client
```java
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
```
## server
```java
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
```