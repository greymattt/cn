import java.io.*;
import java.net.*;
import java.util.*;
public class servertcp {
    public static void main(String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(8081);
        Socket cs = ss.accept();
        PrintWriter put = new PrintWriter(cs.getOutputStream(), true);
        Scanner st=new Scanner(cs.getInputStream());
        String s = st.nextLine();
        System.out.println("The requested file is : " + s);
        File f = new File(s);
        if (f.exists()) {
            BufferedReader d = new BufferedReader(new FileReader(s));
            String line;
            while ((line = d.readLine()) != null) {
                put.write(line);
            }
            System.out.println("File transfered");
        }
    }
}
