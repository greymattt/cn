import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client {
    public static void main(String args[]) throws IOException
    {  
        long t1, t2;
        while(true)
        {
            try{
            Socket soc = new Socket("localhost",2000);
            
            Scanner br=new Scanner(System.in);
            System.out.println("Type a string to ping : ");
            String str = br.nextLine();
            
            PrintWriter pw = new PrintWriter(soc.getOutputStream(),true);
            Scanner br1=new Scanner(soc.getInputStream());
            t1 = System.currentTimeMillis();
            pw.println(str);
            
            String str1 = br1.nextLine();
            t2 = System.currentTimeMillis();
            System.out.println("Pinging "+soc.getInetAddress()+" with string "+str );
            System.out.println("Reply from "+soc.getInetAddress() +" String "+str1+" Length : "+str1.length());
            System.out.println("Sent : "+str.length()+" Received : "+str1.length()+" Lost : "+(str.length()-str1.length()));
            System.out.println("Approx. Time in Milliseconds  = "+(t2-t1));
            }
            catch(Exception e)
            {
                System.out.println("Error : "+e.getMessage());
            }
        }
            
    }
}

