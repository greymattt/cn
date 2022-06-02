import java.io.*;
import java.util.Scanner;
public class gobackn {
    
    public static void main(String[] args) throws Exception {
        try{
            System.out.println("Window Size");
            Scanner sc=new Scanner(System.in);
            int window =sc.nextInt();
            int start = 0;
            while(true){
                for (int i = start; i < window; i++)
                System.out.println("Frame " + i + " has been Transmitted");
                System.out.println("Enter the last Acknowledgement Recieved");
                int akg = sc.nextInt();
                if (akg == window) {
                    System.out.println("All " + window + " Frame has been Transmitted");
                    break;
                }
                start = akg;
            }
        }
        catch(Exception e){
            System.out.println(" I have error "+e);
        }
    }
}
