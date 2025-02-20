import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int buddhismYear = Integer.parseInt(br.readLine());
        int koreanYear = buddhismYear - 543;
        
        System.out.print(koreanYear);
        
        br.close();
    }
} 