import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int k = board[r][c];
				//목적지 도착
				if(r == N-1 && c == N-1) continue;
				
				if(r+k < N) dp[r+k][c] += dp[r][c];
				if(c+k < N) dp[r][c+k] += dp[r][c];
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}
}