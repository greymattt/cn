import java.io.*;
import java.net.*;
import java.util.Scanner; 
class concurrentclient {
    public static void main(String ss[]) throws Exception {
        try {
            System.out.println("Enter quit to terminate the connection !!!");
            Socket s = new Socket("localhost", 4444);
            Scanner in=new Scanner(System.in);
            Scanner out= new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            System.out.println("Client running !!!");
            String msg = "";
            while (true) {
                msg = in .nextLine();
                if (msg.equals("quit")) {
                    break;
                }
                pw.println(msg);
                msg = out.nextLine();
                System.out.println("from server:" + msg);
                if (msg.equals("quit")) {
                    break;
                }
            }
            System.out.println("connection terminated !!!");
            pw.println(msg);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
