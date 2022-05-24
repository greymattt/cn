import java.util.*;
import java.net.*;
import java.io.*;
public class client {
    static Socket conn;
    public static void main(String[] args) throws Exception {
        ArrayList < Integer > list = new ArrayList < Integer > ();
        InetAddress address = InetAddress.getByName("LocalHost");
        System.out.println(address);
        conn = new Socket(address, 5555);
        DataOutputStream dout = new
        DataOutputStream(conn.getOutputStream());
        DataInputStream din = new DataInputStream(conn.getInputStream());
        int frames = din.read();
        System.out.println("No Of Frames is: " + frames);
        for (int i = 0; i < frames; i++) {
            list.add(din.read());
            System.out.println(list.get(i));
        }
        Random random = new Random();
        int rand = random.nextInt(frames);
        list.set(rand, -1);
        System.out.println(list);
        int n = 0;
        for (int i = 0; i < frames; i++)
            if (list.get(i) == -1) {
                System.out.println("Request to retransmit from packet no"+(i+1)+"again!!!"); 
                    n = i; dout.write(n); dout.flush();
                }
                System.out.println();
                list.set(n, din.read());
                System.out.println("Recieved Frame is " + list.get(n));
                System.out.println("Ending....!!!!");
            }
    }
