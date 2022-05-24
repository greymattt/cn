package dcn_lab;

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
