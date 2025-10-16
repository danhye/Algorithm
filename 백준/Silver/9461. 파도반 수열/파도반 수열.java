import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			long ans = 0;
			
			if(N <= 3) ans = 1;
			else {
				long[] dp = new long[N+1];
				for(int i = 1; i <= 3; i++) dp[i] = 1;
				
				for(int j = 4; j <= N; j++) {
					dp[j] = dp[j-2] + dp[j-3];
				}
				
				ans = dp[N];
			}
			
			System.out.println(ans);
		}
	}
}