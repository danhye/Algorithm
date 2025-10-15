import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			if(n == 1) ans = Math.max(sticker[0][0], sticker[1][0]);
    		else if(n == 2) ans = Math.max(sticker[0][0] + sticker[1][1], sticker[0][1] + sticker[1][0]);
			else {
				int[][] dp = new int[n][3]; 
				//dp[i][0] : i번째 열 위쪽 스티커 선택했을때
				//dp[i][1] : i번째 열 아래쪽 스티커 선택했을때
				//dp[i][2] : i번째 열 선택 안했을때
				
				dp[0][0] = sticker[0][0];
				dp[0][1] = sticker[1][0];
				
				dp[1][0] = sticker[0][1] + sticker[1][0];
				dp[1][1] = sticker[1][1] + sticker[0][0];
				dp[1][2] = Math.max(sticker[0][0], sticker[1][0]);
				
				for(int i = 2; i < n; i++) {
					dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + sticker[0][i];
					dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + sticker[1][i];
					dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]);
				}
				
				ans = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
			}
			
			System.out.println(ans);
		}
	}
}