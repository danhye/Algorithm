import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
	
	static int N, M;
	static List<List<Integer>> adjList;
	static int[] inDegree;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] NM = br.readLine().split(" ");
			N = Integer.parseInt(NM[0]); //학생 수
			M = Integer.parseInt(NM[1]); //순서의 개수
			
			adjList = new ArrayList<>();
			for (int i = 0; i < N+1; i++) {
				adjList.add(new ArrayList<>());
			}
			inDegree = new int[N+1];
			
			for (int i = 0; i < M; i++) {
				String[] input = br.readLine().split(" ");
				int from = Integer.parseInt(input[0]);
				int to = Integer.parseInt(input[1]);
				
				adjList.get(from).add(to);
				inDegree[to]++;
			}
			
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			topologySort();
			
			
			
			
			System.out.println(sb);
		} //테케 끝
	}

	private static void topologySort() {
		List<Integer> res = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		//진입차수가 0인 정점들을 다 q에 넣기
		for (int i = 1; i < N+1; i++) {
			if(inDegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			res.add(curr);
			
			//인접된 정점들에 대한 진입차수 감소
			for(int next : adjList.get(curr)) {
				//현재 정점과 연결된 정점의 진입차수 감소
				inDegree[next]--;
				//새로 진입차수 0된 정점들 큐에 추가
				if(inDegree[next] == 0) q.offer(next);
			}
			
		}
		
		for (int i = 0; i < res.size(); i++) {
			sb.append(res.get(i)).append(" ");
		}
	}
}
