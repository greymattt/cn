import java.io.*;
import java.net.*;
import java.lang.*;

class traceroute
{
    public static void main(String args[]){

    BufferedReader in;

        try{
            Runtime r   =   Runtime.getRuntime();
            Process p   =   r.exec("traceroute www.google.com");

            in  =   new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            if(p==null)
                System.out.println("could not connect");

            while((line=in.readLine())!=null){

                System.out.println(line);

                //in.close();
            }

        }catch(Exception e){

        System.out.println(e.toString());

        }
    }
}

