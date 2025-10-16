import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board;
	static boolean[][] isVisited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int max;
	
	public static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		isVisited[sr][sc] = true;
		int currSize = 1; // 그림 사이즈
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= n || nc >= m || nr < 0 || nc < 0 || isVisited[nr][nc] || board[nr][nc] == 0) continue;
				else {
					currSize++;
					isVisited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
		if(max < currSize) max = currSize;
	}
	
	
	public static void main(String[] args) throws IOException {
		/*
		 * 출력 : 그림의 개수, 그럼 중 넓이가 가장 넓은 것의 넓이
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); //세로 크기
		m = Integer.parseInt(st.nextToken()); //가로 크기
		
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isVisited = new boolean[n][m];
		max = 0; //그림의 최대 넓이
		int cnt = 0; //그림의 갯수
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if(board[r][c] == 1 && !isVisited[r][c]) {
					bfs(r,c);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
}