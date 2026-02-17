import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rest = new int[42];

        for(int i = 1; i <= 10; i++){
            int num = Integer.parseInt(br.readLine());
            int restNum = num % 42;
            rest[restNum]++;
        }

        int ans = 0;
        for(int i = 0; i < rest.length ; i++){
            if(rest[i] > 0) ans++;
        }

        System.out.println(ans);
    }
}