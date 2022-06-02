import java.util.*;
import java.io.*;
import java.net.*;
public class receiver {
    public static void main(String[] args) throws Exception {
        String msg = "message";
        ServerSocket serversocket = new ServerSocket(4444);
        System.out.println("waiting for to client ");
        Socket socket = serversocket.accept();
        System.out.println("connected to client ");
        Scanner br=new Scanner(socket.getInputStream());
        PrintWriter ps = new PrintWriter(socket.getOutputStream());
        while (true) {
            msg = br.nextLine();
            System.out.println("Frame " + msg + " was received");
            if (msg.equals("quit"))
                break;
            ps.println("Received");
        }
        System.out.println("All Frames were Received Successfully");
    }
}
