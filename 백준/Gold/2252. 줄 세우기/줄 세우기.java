import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; //학생수, 비교횟수
	static int[] inDegree; //진입차수 저장할 배열
	static List<List<Integer>> adjList; //인접리스트
	
	private static List<Integer> topologySort() {
		List<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		//진입차수가 0인 정점들을 다 q에 넣기
		for (int i = 1; i < inDegree.length; i++) {
			if(inDegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			ans.add(curr);
			
			//인접한 정점들에 대해 진입차수 감소
			for(int next : adjList.get(curr)) {
				//현재 정점과 연결된 진입차수 감소
				inDegree[next]--;
				//새롭게 진입차수 0된 정점들 q에 넣기
				if(inDegree[next] == 0) q.offer(next);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); //학생수
		M = Integer.parseInt(st.nextToken()); //비교한 횟수
		
		adjList = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			adjList.add(new ArrayList<>());
		}
		inDegree = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(to);
			inDegree[to]++;
		}
		
		List<Integer> ans = topologySort();
		for (int a : ans) System.out.print(a + " ");
	}
}