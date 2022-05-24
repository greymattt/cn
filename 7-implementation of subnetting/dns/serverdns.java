import java.io.*;
import java.net.*;
import java.util.*; 
public class Serverdns {
    public static void main(String args[]) {
        try {
            DatagramSocket server = new DatagramSocket(1309);
            while (true) {
                byte[] sendbyte = new byte[1024];
                byte[] receivebyte = new byte[1024];
                DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
                server.receive(receiver);
                String str = new String(receiver.getData());
                String s = str.trim();
                System.out.println("Server Running...");
                InetAddress addr = receiver.getAddress();
                int port = receiver.getPort();
                String ip[] = {
                    "142.250.67.68",
                    "50.62.160.129",
                    "107.20.88.71"
                };
                String name[] = {
                    "www.google.com",
                    "www.skcet.com",
                    "www.amazon.com"
                };
                for (int i = 0; i < ip.length; i++) {
                    if (s.equals(ip[i])) {
                        sendbyte = name[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        break;
                    } else if (s.equals(name[i])) {
                        sendbyte = ip[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        break;
                    }

                }
                System.out.println("IP address or DOMAIN NAME sent...");
                break;


            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
