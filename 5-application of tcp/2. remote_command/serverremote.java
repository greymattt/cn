import java.io.*;
import java.net.*;
import java.util.Scanner;
public class serverremote {
    public static void main(String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(8081);
        Socket s = ss.accept();
        String cmd;
        Scanner in=new Scanner(s.getInputStream());
        cmd = in.nextLine();
        try {
            Runtime r = Runtime.getRuntime();
            Process a = r.exec(cmd);
            System.out.println("Executing command : " + cmd);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        s.close();
    }
}
