import java.util.*;
import java.io.*;
import java.net.*;
public class sender {
    static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("localhost", 4444);
        PrintStream ps = new PrintStream(socket.getOutputStream());
        System.out.println("No of frames to be Sent");
        int frames = scan.nextInt();
        int i = 0;
        while (i <= frames) {
            System.out.println("Frame " + i + " is Sent");
            ps.println(i);
            Scanner br=new Scanner(socket.getInputStream());
            String akg = br.nextLine();
            if (akg != null) {
                System.out.println("Acknowledgement was received from the received");
                    i++;
                }
                else
                    ps.println(i);
            }
            ps.println("exit");
        }
    }
