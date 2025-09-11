import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {	
	static final int INF = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // N : 학생들의 수
			int M = Integer.parseInt(br.readLine()); // M : 비교한 횟수
			
			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) dist[i][j] = 0;
					else dist[i][j] = INF;
				}
			}
			
			for (int i = 0; i < M; i++) {
				String[] input = br.readLine().split(" ");
				int small = Integer.parseInt(input[0]);
				int tall = Integer.parseInt(input[1]);
				dist[small-1][tall-1] = 1; //나보다 큰 사람
			}
			
			//플로이드워셜
			for (int k = 0; k < N; k++) {
				for (int from = 0; from < N; from++) {
					if(dist[from][k] == INF) continue;
					for (int to = 0; to < N; to++) {
						if(dist[k][to] == INF) continue;
						dist[from][to] = Math.min(dist[from][to],dist[from][k] + dist[k][to]);
					}
				}
			}
			
			//확인용
//			for (int i = 0; i < N; i++) {
//				for(int a : dist[i]) System.out.print(a);
//				System.out.println();
//			}
//			
			
			int ans = 0;
			for (int i = 0; i < N; i++) {
				int shorter = 0, taller = 0;
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					if(dist[i][j] < INF) shorter++; //i에서 j로 가는 경로가 존재한다. 이 말은 i < j
					if(dist[j][i] < INF) taller++; //j에서 i로 가는 경로가 존재한다. 이 말은 j < i
				}
				if(shorter + taller == N-1) ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		} //테케 끝
	}
}