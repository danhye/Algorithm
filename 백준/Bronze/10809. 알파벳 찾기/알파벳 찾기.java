import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        for(int i = 97; i <= 122; i++) { //a ~ z
            boolean isAppear = false;
            for(int idx = 0; idx < str.length; idx++) {
                if((char)i == str[idx].charAt(0)){
                    System.out.print(idx + " ");
                    isAppear = true;
                    break;
                }
            }
            if(!isAppear) System.out.print(-1 + " ");
        }
    }
}