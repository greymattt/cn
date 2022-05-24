import java.io.*;
import java.net.*;
import java.util.*;
public class clienttcp {
    public static void main(String srgs[]) throws IOException {
        Socket s = new Socket("localhost", 8081);
        Scanner get = new Scanner(s.getInputStream());
        PrintWriter put = new PrintWriter(s.getOutputStream(), true);
        String u, f;
        System.out.println("Enter the file name to transfer from server:");
        Scanner dis=new Scanner(System.in);
        f = dis.nextLine();
        put.println(f);
        File f1 = new File(f);
        FileOutputStream fs = new FileOutputStream(f1);
        while ((u = get.nextLine()) != null) {
            byte jj[] = u.getBytes();
            fs.write(jj);
        }
        System.out.println("File received");
    }
}
