import java.util.*;
import java.io.*;
import java.net.*;
public class receiver {
    public static void main(String[] args) throws Exception {
        String msg = "message", str = "exit";
        ServerSocket serversocket = new ServerSocket(4444);
        Socket socket = serversocket.accept();
        Scanner br=new Scanner(socket.getInputStream());
        PrintStream ps = new PrintStream(socket.getOutputStream());
        while (!msg.equals(str)) {
            msg = br.nextLine();
            if (msg.equals(str))
                break;
            System.out.println("Frame " + msg + " was received");
            ps.println("Received");
        }
        System.out.println("All Frames were Received Successfully");
    }
}
