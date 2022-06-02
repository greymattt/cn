import java.util.*;
import java.net.*;
import java.io.*;
public class client {
    
    public static void main(String[] args) throws Exception {
        
        Socket conn = new Socket("localhost", 5555);
        Scanner in = new Scanner(conn.getInputStream());
        PrintWriter pw=new PrintWriter(conn.getOutputStream(),true);

        int frames = in.nextInt();

        int[]list=new int[frames];

        System.out.println("No Of Frames is: " + frames);

        for (int i = 0; i < frames; i++) {
            list[i]=in.nextInt();
            System.out.println("receiveed: "+list[i]);
        }
        list[2]=-1;
        for(int i=0;i<frames;i++)
        System.out.println(list[i]+" ");

        int n = 0;
        for (int i = 0; i < frames; i++)
        if (list[i] == -1) {
                System.out.println("Request to retransmit from packet no"+(i+1)+"again!!!"); 
                n = i; 
                pw.println(i);
            }
            System.out.println();
            list[n]=in.nextInt();
            System.out.println("Recieved Frame is " + list[n]);
            System.out.println("Ending....!!!!");
        }


    }
