import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ans = 0;
        int nums = st.countTokens();
        for(int i = 0; i < nums; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > 1){
                boolean isPrime = false;
                for(int j = 2; j < num; j++){
                    if(num % j == 0) {
                        isPrime = true;
                        break;
                    }
                }
                if(!isPrime) ans += 1;
            }
        }
        System.out.println(ans);
    }
}