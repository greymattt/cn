import java.io.*;
import java.net.*;
public class clientremote {
    public static void main(String args[]) throws IOException {
        try {
            Socket s = new Socket("localhost", 8081);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            String cmd;
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the command to execute on server : ");
            cmd = in.nextLine();
            out.println(cmd);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
