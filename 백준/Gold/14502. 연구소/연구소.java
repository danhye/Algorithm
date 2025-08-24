import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M, maxSafeArea;
	static int[][] map; // 원본 지도
	static List<int[]> initialViruses; 
	
	// 방향 체크 (상하좌우)
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		map = new int[N][M];
		initialViruses = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				// 초기 바이러스 위치 저장
				if (map[i][j] == 2) {
					initialViruses.add(new int[] {i, j});
				}
			}
		}

		maxSafeArea = 0;

		buildWall(0);
		
		System.out.println(maxSafeArea);
	}

	private static void buildWall(int wallCount) {
        //종료조건
		if (wallCount == 3) {
			spreadVirus();
			return; 
		}
		
		//재귀
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { 
					map[i][j] = 1; 
					buildWall(wallCount + 1); 
					map[i][j] = 0; //상태 원복
				}
			}
		}
	}
	
	private static void spreadVirus() {
		int[][] temp = new int[N][M];
		for(int i = 0; i < N; i++) {
			temp[i] = map[i].clone();
		}

		Queue<int[]> queue = new LinkedList<>();
		for (int[] virus : initialViruses) {
			queue.add(virus);
		}
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];
			
			for (int i = 0; i < 4; i++) { 
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && temp[nr][nc] == 0) {
					temp[nr][nc] = 2; 
					queue.add(new int[] {nr, nc});
				}
			}
		}
		
		// 안전 영역 크기 계산
		int safeArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0) {
					safeArea++;
				}
			}
		}
		
		// 최댓값 갱신
		maxSafeArea = Math.max(maxSafeArea, safeArea);
	}
}