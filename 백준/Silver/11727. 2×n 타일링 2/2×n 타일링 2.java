import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

/*      dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        dp[4] = 11;
        dp[5] = 21;
        dp[6] = 43;
        점화식 : dp[n] = 2*dp[n-2] + dp[n-1] */

        dp[1] = 1;
        if(n >= 2) dp[2] = 3;

        for(int i = 3; i <= n; i++){
            dp[i] = (2*dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[n]);
    }
}