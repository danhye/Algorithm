import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] maze;
	static int[][] dist; //최소 거리 저장용
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] visited;
	
	private static int bfs(int sr, int sc ) {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{sr, sc});
		visited[sr][sc] = true;
		dist[sr][sc] = 1; //시작점은 거리 1
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];
			
			if(r == N-1 && c == M-1) return dist[r][c];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || maze[nr][nc] == 0)
					continue;
				else {
					visited[nr][nc] = true;
					dist[nr][nc] = dist[r][c] + 1;
					q.offer(new int[] {nr, nc});
				}
			}
		}

		return -1; //도달하지 않
	}
	
	
	public static void main(String[] args) throws IOException {
		// 1 : 이동 가능 , 0 : 이동 불가
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j)-'0';
			}
		}
		
		visited = new boolean[N][M];
		dist = new int[N][M];
		
		int ans = bfs(0,0);
		System.out.println(ans);
	}
}