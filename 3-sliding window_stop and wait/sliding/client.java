import java.util.*;
import java.net.*;
import java.io.*;
public class client {
    static Socket conn;
    public static void main(String[] args) throws Exception {
        
        InetAddress address = InetAddress.getByName("LocalHost");
        System.out.println(address);
        conn = new Socket(address, 5555);
        DataOutputStream dout = new DataOutputStream(conn.getOutputStream());
        DataInputStream din = new DataInputStream(conn.getInputStream());
        int frames = din.read();
        int[]list=new int[frames];
        System.out.println("No Of Frames is: " + frames);
        for (int i = 0; i < frames; i++) {
            list[i]=(din.read());
            System.out.println(list[i]);
        }
        Random random = new Random();
        int rand = random.nextInt(frames);
        list[rand]=-1;
        for(int i=0;i<frames;i++)
        System.out.println(list[i]+" ");
        int n = 0;
        for (int i = 0; i < frames; i++)
            if (list[i] == -1) {
                System.out.println("Request to retransmit from packet no"+(i+1)+"again!!!"); 
                    n = i; dout.write(n); dout.flush();
                }
                System.out.println();
                list[n]=din.read();
                System.out.println("Recieved Frame is " + list[n]);
                System.out.println("Ending....!!!!");
            }
    }
