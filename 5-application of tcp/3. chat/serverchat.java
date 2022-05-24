import java.io.*;
import java.net.*;
class serverchat {
    public static void main(String ss[]) throws Exception {
        try {
            System.out.println("Server is Running !!!");
            ServerSocket s1 = new ServerSocket(4444);
            Socket s = s1.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader out = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            System.out.println("Server running !!!");
            String msg = "";
            while (true) {
                msg = out.readLine();
                System.out.println("from client:" + msg);
                if (msg.equals("quit")) {
                    break;
                }
                msg = in .readLine();
                if (msg.equals("quit")) {
                    break;
                }
                pw.println(msg);
            }
            System.out.println("connection terminated !!!");
            pw.println(msg);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
