import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] nums = {1,2,3};
			int[] dp = new int[n+1];
			dp[0] = 1;
			
			for(int i = 1; i <= n; i++) {
				for(int num : nums) {
					if(i - num >= 0) {
						dp[i] += dp[i - num];
					}
				}
			}
			
			
			
			System.out.println(dp[n]);
		}
	}
}