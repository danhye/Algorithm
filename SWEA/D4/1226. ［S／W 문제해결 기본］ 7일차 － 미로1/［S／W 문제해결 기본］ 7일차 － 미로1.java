import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] maze;
	static int[] start; 
	static int[] goal;
	
	//사방탐색 상 하 좌 우
	static int[] dr = {1, -1 , 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean isSuccess;
	static boolean[][] visited;
	
	private static void escape(int r, int c) {
		//종료조건
		if(r == goal[0] && c == goal[1]) {
			isSuccess = true;
			return;
		}
		
		//방문표시
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			//배열의 범위 안에 있고, 방문하지 않았고, 벽(1)이 아니면 이면 가랏!
			if(nr >=0 && nc >= 0 && nr < 16 && nc < 16 && !visited[nr][nc] && maze[nr][nc] != 1) {
				escape(nr, nc);
			}
		}
		
		visited[r][c] = false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 1 : 벽 , 0 : 길, 2 : 츨발점, 3 : 도착점
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			maze = new int[16][16];
			start = new int[2]; goal = new int[2];
			
			for (int i = 0; i < 16; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < 16; j++) {
					maze[i][j] = Integer.parseInt(input[j]);
					if(maze[i][j] == 2) {
						start[0] = i; start[1] = j;
					}
					if(maze[i][j] == 3) {
						goal[0] = i; goal[1] = j;
					}
				}
			} //입력받기 끝
			
			isSuccess = false;
			visited = new boolean[16][16];
			escape(start[0], start[1]);
			System.out.println("#" + tc + " " + (isSuccess ? 1 : 0));		
		} //테케 끝
	}
}