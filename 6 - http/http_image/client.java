
import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

 
public class clienthttp{
    public static void main(String args[]) throws Exception{
        
        
        Socket soc=new Socket("localhost",4000);

        System.out.println("Client is running. ");
        System.out.println("Reading image from disk. ");
        BufferedImage img= ImageIO.read(new File("image.jpg"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);

        byte[] bytes = baos.toByteArray();
        
        System.out.println("Sending image to server. ");

        PrintWriter pw=new PrintWriter(soc.getOutputStream());

        pw.writeInt(bytes.length);

        pw.write(bytes, 0, bytes.length);

        System.out.println("Image sent to server. ");

        pw.close();
        baos.close();
        soc.close();
    }
}