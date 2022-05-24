import java.util.*;
import java.io.*;
import java.net.*;
public class sender {
    static ServerSocket serversocket;
    static DataInputStream din;
    static DataOutputStream dout;
    public static void main(String[] args) throws Exception {
        ArrayList < Integer > list = new ArrayList < Integer > ();
        int arr[] = {
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100
        };
        for (int i: arr)
            list.add(i);
        serversocket = new ServerSocket(5555);
        System.out.println("Waiting for Connection");
        Socket client = serversocket.accept();
        din = new DataInputStream(client.getInputStream());
        dout = new DataOutputStream(client.getOutputStream());
        System.out.println("Total Packets sent is " + list.size());
        dout.write(list.size());
        dout.flush();
        for (int i = 0; i < list.size(); i++) {
            dout.write(list.get(i));
            dout.flush();
        }
        dout.write(list.get(din.read()));
        dout.flush();
        din.close();
        dout.close();
    }
}
