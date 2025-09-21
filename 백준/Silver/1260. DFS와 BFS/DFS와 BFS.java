import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V; //정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호
	static List<List<Integer>> adjList;
	static boolean[] visited;
	
	//정답 담기
	static StringBuilder dfsAns = new StringBuilder();
	static StringBuilder bfsAns = new StringBuilder();
	
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		
		//visited 배열 초기화
		Arrays.fill(visited, false);
		visited[V] = true;
		
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			bfsAns.append(curr).append(" ");
			
			for(int next : adjList.get(curr)) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}


	private static void dfs(int v) {
		visited[v] = true;
		dfsAns.append(v).append(" ");
		
		for(int next : adjList.get(v)) {
			if(!visited[next]) dfs(next);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<>();	
		for (int i = 0; i < N+1; i++) {
			adjList.add(new ArrayList<>());
		}
		visited = new boolean[N+1]; //번 간선부터 시작
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			//무향 그래프
			adjList.get(from).add(to);
			adjList.get(to).add(from);
		}
		
		//방문할 수 있는 정점이 여러개인 경우에는 정점 번호가 작은 것 먼저 방문
		for (int i = 1; i < N+1; i++) {
			Collections.sort(adjList.get(i));
		}

		dfs(V); bfs();
		
		System.out.println(dfsAns);
		System.out.println(bfsAns);
	} //main 끝
}
