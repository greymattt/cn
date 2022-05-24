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
        Scanner out=new Scanner(s.getInputStream());
        PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
        String msg=""; 
        while(true)
        {
                msg=out.nextLine();
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
