import java.util.*;
import java.io.*;
import java.net.*;
public class sender {
    static ServerSocket serversocket;
    static DataInputStream din;
    static DataOutputStream dout;
    public static void main(String[] args) throws Exception {
        
        int list[] = {30,40,50,60,70,80,90,100};
        serversocket = new ServerSocket(5555);
        System.out.println("Waiting for Connection");
        Socket client = serversocket.accept();
        din = new DataInputStream(client.getInputStream());
        dout = new DataOutputStream(client.getOutputStream());
        System.out.println("Total Packets sent is " + list.length);
        dout.write(list.length);
        dout.flush();
        for (int i = 0; i < list.length; i++) {
            dout.write(list[i]);
            dout.flush();
        }
        dout.write(list[din.read()]);
        dout.flush();
        din.close();
        dout.close();
    }
}
