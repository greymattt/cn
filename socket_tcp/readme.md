# algorithm
## CLIENT:

Step 01: Start the program.  
Step 02: Create a socket with port number and net address.  
Step 03: Get the input from the user using Reader class.  
Step 04: Write the same to server using Printwriter class.  
Step 05: Read the data from the server and print the same on the console output.  
Step 06: Repeat the same until the user wants to quit.  
Step 07: End the program.  

## SERVER:

Step 01: Start the program.  
Step 02: Establish a socket of server socket type.  
Step 03: Accept the connection from the client.  
Step 04: Read the input from the client and print the same on the console output.  
Step 05: Pass the same data to the client using Printwriter class.  
Step 06: Repeat the same until the user wants to quit.  
Step 07: End the program.  

# code
## client
```java
import java.util.*;
import java.io.*;
import java.net.*;

public class client 
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Enter quit to terminate the connection !!!");
            Socket s=new Socket("localhost",4444);
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader out=new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
            System.out.println("Client running !!!");
            String msg="";
            while(true)
            {
                    msg=in.readLine();
                    pw.println(msg);
                    msg=out.readLine();
                    if(msg.equals("quit"))
                    {
                            break;
                    }
                    System.out.println("from server:"+msg);
            }
            System.out.println("connection terminated !!!");
            pw.println(msg);
        }
        catch(Exception e)
        {
                System.out.println(e);
        }

    }
}
```
# server 
```java
package dcn_lab;

import java.util.*;
import java.net.*;
import java.io.*;
public class Server_Using_TCP 
{

    public static void main(String[] args)
    {
        try
        {
        System.out.println("Server is Running !!!");
        ServerSocket s1=new ServerSocket(4444);
        Socket s=s1.accept();
        BufferedReader out=new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
        String msg=""; 
        while(true)
        {
                msg=out.readLine();
                System.out.println("from client:"+msg);
                if(msg.equals("quit"))
                {
                        break;
                }
                pw.println(msg);
        }
        System.out.println("connection terminated !!!");
        pw.println(msg);
        }
        catch(Exception e)
        {
                System.out.println(e);
        }
    }
}
```