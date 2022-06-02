import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.lang.*;
 
 
class concurrent_server {
    public static void main(String ss1[]) throws Exception {
        int i = 0;
        System.out.println("Server Started .....");
        try {
            ServerSocket s1 = new ServerSocket(4444);
            while (true) {
                Socket ss = s1.accept();
                System.out.println("Connected with the client:" + i);
                Thread t = new Thread(new server(ss, i));
                i++;
                t.start();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
}

class server implements Runnable {
    Socket s;
    int counter;
    server(Socket sock, int counter) {
        this.s = sock;
        this.counter = counter;
    }
    public void run() {
        try {
            Scanner in=new Scanner(System.in);
            Scanner out = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            System.out.println("Server running !!!");
            String msg = "";
            while (true) {
                msg = in.nextLine();
                System.out.println("from client:" + msg);
                if (msg.equals("quit")) {
                    break;
                }
                msg = out .nextLine();
                if (msg.equals("quit")) {
                    break;
                }
                pw.println(msg);
            }
            System.out.println("connection terminated !!!");
            pw.println(msg);
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

}
