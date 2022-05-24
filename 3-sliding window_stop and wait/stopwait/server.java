import java.util.*;
import java.io.*;
import java.net.*;
public class receiver {
    public static void main(String[] args) throws Exception {
        receiver receiver = new receiver();
        receiver.start();
    }
    public static void start() throws Exception {
        String msg = "message", str = "exit";
        ServerSocket serversocket = new ServerSocket(4444);
        Socket socket = serversocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        while (!msg.equals(str)) {
            Thread.sleep(1000);
            msg = br.readLine();
            if (msg.equals(str))
                break;
            System.out.println("Frame " + msg + " was received");
            Thread.sleep(500);
            ps.println("Received");
        }
        System.out.println("All Frames were Received Successfully");
    }
}
