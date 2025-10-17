import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	private static int bfs(int n, int k) {
		final int BOUND = 200000;
		Queue<Integer> q = new ArrayDeque<>();
		
		int[] dist = new int[BOUND + 1];
		Arrays.fill(dist, -1);
		dist[n] = 0; //n까지 가는데 걸리는 최소 시간은 0
		
		q.offer(n);
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == k) return dist[k];
			
			int[] nexts = {curr - 1, curr + 1, curr * 2};
			for(int next : nexts) {
				if(next >= 0 && next <= BOUND && dist[next] == -1) {
					dist[next] = dist[curr] + 1;
					q.offer(next);
				}
			}
		}
		return dist[k];	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = bfs(N, K);
		
		System.out.println(ans);
	}
}