import java.io.*;
public class gobackn {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        System.out.println("Window Size");
        int window = Integer.parseInt(br.readLine());
        int start = 0;
        do {
            for (int i = start; i < window; i++)
                System.out.println("Frame " + i + " has been Transmitted");
            System.out.println("Enter the last Acknowledgement Recieved");
            int akg = Integer.parseInt(br.readLine());
            if (akg == window) {
                System.out.println("All " + window + " Frame has been Transmitted");
                break;
            }
            start = akg;
        } while (true);
    }
}
