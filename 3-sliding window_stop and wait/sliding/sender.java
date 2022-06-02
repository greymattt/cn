import java.util.*;
import java.io.*;
import java.net.*;
public class sender {
    public static void main(String[] args) throws Exception {
        
        int list[] = {30,40,50,60,70,80,90,100};
        ServerSocket serversocket = new ServerSocket(5555);
        System.out.println("Waiting for Connection");
        Socket client = serversocket.accept();
        Scanner in = new Scanner(client.getInputStream());
        PrintWriter pw=new PrintWriter(client.getOutputStream());
        System.out.println("Total Packets sent is " + list.length);
        pw.println(list.length);
        
        for (int i = 0; i < list.length; i++) {
            pw.println(list[i]);
        }
        int lost=in.nextInt();
        pw.println(list[lost]);
        

        in.close();
        pw.close();
        client.close();
        serversocket.close();
    }
}
