import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
class server {
    public static void main(String args[]) throws IOException
    {
        ServerSocket s = new ServerSocket(2000);
        while(true)
        {
            Socket c = s.accept();
            Scanner br=new Scanner(c.getInputStream());
            String str = br.nextLine();
            System.out.println("Ping command received from : "+c.getInetAddress() +" with string "+str);
            PrintWriter ps = new PrintWriter(c.getOutputStream(),true);
            ps.println(str);
        }
    }
}
