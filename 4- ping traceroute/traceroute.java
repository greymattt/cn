import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.lang.*;

class traceroute
{
    public static void main(String args[]){

    Scanner in;

        try{
            Runtime r   =   Runtime.getRuntime();
            Process p   =   r.exec("traceroute www.google.com");

            in  =   new Scanner(p.getInputStream());

            String line;

            if(p==null)
                System.out.println("could not connect");

            while((line=in.nextLine())!=null){

                System.out.println(line);

                //in.close();
            }

        }catch(Exception e){

        System.out.println(e.toString());

        }
    }
}

