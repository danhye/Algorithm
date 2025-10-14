import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M , N, K;
	static int[][] ground;
	static boolean[][] isVisited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken()); //배추밭의 가로길이
			N = Integer.parseInt(st.nextToken()); //배추밭의 세로길이
			K = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 위치의 개수
			
			ground = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken()); //배추 위치 열
				int r = Integer.parseInt(st.nextToken()); //배추 위치 행
				ground[r][c] = 1;
			}
			
			int ans = 0;
			isVisited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(ground[i][j] == 1 && !isVisited[i][j]) ans += bfs(i,j);
				}
			}
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr,sc});
		isVisited[sr][sc] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				//배열 범위 체크
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(isVisited[nr][nc] || ground[nr][nc] == 0) continue;
				isVisited[nr][nc] = true;
				q.offer(new int[] {nr,nc});
			}
		}

		return 1;
	}
}
