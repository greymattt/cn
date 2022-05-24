import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
class hserver {
    public static void main(String args[]) throws Exception{

        ServerSocket server = new ServerSocket(4000);

        System.out.println("Server Waiting for image");
        Socket socket = server.accept();

        System.out.println("Client connected.");

        InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);

        int len = dis.readInt();
        System.out.println("Image Size: " + len/1024 + "KB");
        byte[] data = new byte[len];
        dis.readFully(data);
        

        InputStream ian = new ByteArrayInputStream(data);
        BufferedImage bImage = ImageIO.read(ian);

        JFrame f = new JFrame("Server");
        ImageIcon icon = new ImageIcon(bImage);
        JLabel l = new JLabel();
        l.setIcon(icon);
        f.add(l);
        f.pack();
        f.setVisible(true);

        server.close();
        ian.close();
        dis.close();
        in.close();
    }
}