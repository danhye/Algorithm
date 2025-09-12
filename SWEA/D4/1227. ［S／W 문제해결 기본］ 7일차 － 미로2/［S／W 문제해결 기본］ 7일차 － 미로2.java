import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[][] maze;
	static int[] start, goal;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static int bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();	
		q.offer(new int[] {sr,sc});
		visited[sr][sc] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d]; 
				int nc = curr[1] + dc[d];
				
				//배열 범위 벗어났거나 와봤거나 벽이면 나가셈
				if(nr < 0 || nc < 0 || nr >= 100 || nc >= 100 || visited[nr][nc] || maze[nr][nc] == 1 ) continue;
				else {
					//도착했으면 나가
					if(nr == goal[0] && nc == goal[1]) return 1;
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		//도착 못했으면 0
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 0 : 길 , 1 : 벽, 2 : 출발점, 3 도착점
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine()); 
			maze = new int[100][100];
			start = new int[2];
			goal = new int[2];
			visited = new boolean[100][100];
			
			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0; j < 100; j++) {
					maze[i][j] = line.charAt(j) - '0';
					if(maze[i][j] == 2) {
						start[0] = i; start[1] = j;  
					}
					if(maze[i][j] == 3) {
						goal[0] = i; goal[1] = j;
					}
				}
			} //입력받기 끝
			
			int ans = bfs(start[0], start[1]);
			System.out.println("#" + tc + " " + ans);
		} //테케끝
	}
}
