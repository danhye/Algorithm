import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;


public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
//	static int cnt; //현재 단지의 집 개수
	
	//방향탐색 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	//dfs로 풀기
//	private static void dfs(int r, int c) {
//		visited[r][c] = true;
//		cnt++;
//		
//		for (int d = 0; d < 4; d++) {
//			int nr = r + dr[d];
//			int nc = c + dc[d];
//			
//			if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] == 0) continue;
//			dfs(nr,nc);
//		}
//	}
	

	private static int bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();	
		q.offer(new int[] {sr,sc});
		visited[sr][sc] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				//배열 범위, 방문 여부 체크
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr,nc});
				cnt++;
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		List<Integer> sizes = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) { //방문 안 한 1에서만 시작
//					cnt = 0;
//					dfs(i,j);
//					sizes.add(cnt);
					sizes.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(sizes);
		
		System.out.println(sizes.size());
		for(int s : sizes) System.out.println(s);

	} //main 끝
}