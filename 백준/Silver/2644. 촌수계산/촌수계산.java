import java.util.*;
import java.io.*;

public class Main {
	static int ans = -1; //촌수계산
	static List<List<Integer>> graph;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); //정점
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int personA = Integer.parseInt(st.nextToken());
		int personB = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine()); //간선
		
		graph = new ArrayList<>();
		
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		isVisited = new boolean[n+1];
		dfs(personA, personB, 0);
		
		System.out.println(ans);
	}

	private static void dfs(int curr, int goal, int depth) {		
		
		if(curr == goal) {
			ans = depth;
			return;
		}
		
		isVisited[curr] = true;
		
		for(int next : graph.get(curr)) {
			if(!isVisited[next] && ans == -1) {
				dfs(next, goal, depth + 1);
			}
		}		
		
	}
}