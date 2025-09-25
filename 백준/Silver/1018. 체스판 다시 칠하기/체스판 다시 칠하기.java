import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		char[][] board = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		
		int ans = Integer.MAX_VALUE;
		for (int sr = 0; sr <= N-8; sr++) {
			for (int sc = 0; sc <= M-8; sc++) {
				
				int startW = 0;
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						char expected = ((r+c) % 2 == 0) ? 'W' : 'B';
						if(board[sr+r][sc+c] != expected) startW++;
					}
				}
				
				int startB = 64 - startW;
				ans = Math.min(ans, Math.min(startW, startB));
			}
		}
		
		System.out.println(ans);
	}
}
