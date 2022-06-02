import java.util.*;
import java.io.*;
import java.net.*;
public class sender {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 4444);
        Scanner scan = new Scanner(System.in);
        Scanner in=new Scanner(socket.getInputStream());
        PrintWriter pw=new PrintWriter(socket.getOutputStream());
        System.out.println("No of frames to be Sent");
        int frames = scan.nextInt();
        int i = 0;
        while (i <= frames) {
            System.out.println("Frame " + i + " is Sent");
            pw.println(i);
            
            String akg = in.nextLine();
            if (akg!=null) {
                System.out.println("Acknowledgement was received from the received");
                i++;
            }
            else
                pw.println(i);
            }
            // pw.println("exit");


        }
    }
