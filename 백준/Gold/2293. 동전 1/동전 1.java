import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		/*
		 * 합이 k가 되는 모든 경우의 수 구하기 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); //동전의 종류
		int k = Integer.parseInt(st.nextToken()); //목표 합
		
		int[] coins = new int[n];
		
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k+1]; //금액 k를 만드는 경우의 수
		dp[0] = 1; // 0을 만드는 경우의 수는 하나
		
		for(int c : coins) { // 1 2 5
			if(c > k) continue;
			for(int i = c; i <= k; i++) {
				dp[i] = dp[i] + dp[i-c]; 
			//1을 만드는 경우의 수 = 1을 만드는 경우의 수 + (1-1)을 만드는 경우의 수 0 + 1 = 1 / 1
			//2를 만드는 경우의 수 = 2를 만드는 경우의 수 + (2-1)을 만드는 경우의 수 0 + 1 = 1 / 11
			// ...
			//c 2를 선택하면
			//2를 만드는 경우의 수 = 2를 만드는 경우의 수 + (2-2)을 만드는 경우의 수 1 + 1 = 2 / 11, 2
			}
		}
		
		System.out.println(dp[k]);
	}
}