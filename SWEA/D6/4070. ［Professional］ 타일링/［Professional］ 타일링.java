import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
 
public class Solution {
     
    public static BigInteger dp (int n) {
        BigInteger[] memo = new BigInteger[n+2];
         
        memo[0] = BigInteger.valueOf(0);
        memo[1] = BigInteger.valueOf(1);
        memo[2] = BigInteger.valueOf(3);
         
        for (int i = 3; i < n+1; i++) {
            memo[i] = memo[i-1].add(memo[i-2].multiply(BigInteger.valueOf(2)));
        }
         
        return memo[n];
    }
     
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
             
            BigInteger ans = dp(N);
            System.out.println("#" + tc + " " + ans);
        }
    }
}
