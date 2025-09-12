import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, W; //건물의 개수, 건설순서 규칙 개수, 목표 건물
	static int[] time; //소요시간
	static int[] inDegree; //진입차수 저장 배열
	static List<List<Integer>> adjList; //인접 리스트
	
	private static int topologySort() {
		int[] dp = new int[N+1];
		Queue<Integer> q = new ArrayDeque<>();	

		//진입차수 0인 애들 q에 넣기
		for (int i = 1; i < N+1; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
				//자기 소요시간으로 시작
				dp[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			//가지치기
			if(curr == W) return dp[W]; 

			//인접한 정점들에 대한 진입차수 감소
			for(int next : adjList.get(curr)) {
				//완공하는데 걸리는 가장 빠른 시간
				//선행 건물들 모두 건설되는 시간 기다려야해... 그래서 가장 늦게 끝나는 시간
				if(dp[next] < dp[curr] + time[next]) 
					dp[next] = dp[curr] + time[next];
				
				if(--inDegree[next] == 0) q.offer(next);
			}
		}
		return dp[W];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		
			//초기화들 ..
			adjList = new ArrayList<>();
			for (int i = 0; i < N+1; i++) {
				adjList.add(new ArrayList<>());
			}
			inDegree = new int[N+1];
			time = new int[N+1];
			
			//입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < N+1; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList.get(from).add(to);
				inDegree[to]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			//위상정렬 레추꼬
			System.out.println(topologySort());
		} //테케 끝
	}
}