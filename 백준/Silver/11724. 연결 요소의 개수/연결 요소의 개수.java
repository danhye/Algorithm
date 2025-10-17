import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<List<Integer>> graph;
	static boolean[] isVisited;
	
	static void dfs(int curr) {
		//방문해봤으면, 재귀 종료 !
		if(isVisited[curr]) return;
		
		isVisited[curr] = true;
		for(int next : graph.get(curr)) dfs(next);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		
		//인접리스트로 만들기
		graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);	
		}
		
		
		isVisited = new boolean[N+1];
		int ans = 0;
		
		for(int i = 0; i < N + 1; i++) {
			if(!isVisited[i]) {
				dfs(i);
				ans++;
			}
		}
		
		System.out.println(ans-1);
	}
}