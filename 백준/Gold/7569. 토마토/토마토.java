import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] box;
	static int M, N, H;
	
	//상하좌우 + 높이 위 아래
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(box[i][j][k] == 1) q.offer(new int[] {i, j, k});
				}
			}
		}
		
		int max = 0; //저장될 때부터 모든 토마토가 익어있는 상태라면 0 출력
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int h = curr[0], r = curr[1], c = curr[2];
			
			for (int d = 0; d < 6; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int nh = h + dh[d];
				
				//배열 범위 벗어났는지 체크 + 0이 아닌지 (-1, 그외 숫자) 체크
				if(nr < 0 || nc < 0 || nh < 0 ||nr >= N || nc >= M || nh >= H || box[nh][nr][nc] != 0) continue;
				else if(box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = box[h][r][c] + 1;
					q.offer(new int[] {nh, nr, nc});
				}
				
				
				if(box[nh][nr][nc] > max) max = box[nh][nr][nc] -1; //시작점이 1이였으니까 -1 빼줘야 올바른 날짜 계산 !
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로
		H = Integer.parseInt(st.nextToken()); //높이
		
		box = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		} //입력받기 끝

		//토마토 다 익은 날짜 구하기
		//모두 익지 못하는 상황이면 -1 출력
		int ans = bfs();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(box[i][j][k] == 0) ans = -1;
				}
			}
		}

		
		System.out.println(ans);
				
	}
}