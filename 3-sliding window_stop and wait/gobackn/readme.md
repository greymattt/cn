# algorithm
Step 1: Start the program  
Step 2: Import required classes such as BufferReader, InputStreamReader.   
Step 3: Begin main function   
Step 4: Read Window size   
Step 5: Transmit required frames and print Acknowledgement.    
Step 6: Repeat step 5 untill all frames are transmitted.   
Step 7: End main function   
Step 8: Stop program   

# code
```java
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
```
