import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static class Node implements Comparable<Node>{
        int village;
        int time;

        Node(int village, int time){
            this.village = village;
            this.time = time;
        }

        @Override
        public int compareTo(Node other){
            return this.time - other.time;
        }
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int time = road[i][2];

            graph.get(a).add(new Node(b, time));
            graph.get(b).add(new Node(a, time));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        dist[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            int now = curr.village;
            int time = curr.time;

            if(time > dist[now]) continue;

            for(Node nextNode : graph.get(now)){
                int next = nextNode.village;
                int nextTime = nextNode.time;

                int newTime = nextTime + time;

                if(newTime < dist[next]){
                    dist[next] = newTime;
                    pq.add(new Node(next, newTime));
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}
