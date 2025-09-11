import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static final int INF = 987654321;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken()); // 사람 수, 즉 노드
            //인접행렬,, 행 우선
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            //최단경로 배열 생성
            int[][] dist = new int[N][N];
            //초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) dist[i][j] = 0;
                    else if (arr[i][j] == 1) dist[i][j] = 1;
                    else dist[i][j] = INF;
                }
            }
             
            for (int k = 0; k < N; k++) {
                for (int from = 0; from < N; from++) {
                    if(dist[from][k] == INF) continue;
                    for (int to = 0; to < N; to++) {
                        if(dist[k][to] == INF) continue;
                        dist[from][to] = Math.min(dist[from][to], dist[from][k] + dist[k][to]);
                    }
                }
            }
             
            int ans = INF;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) sum += dist[i][j];
                ans = Math.min(ans, sum); 
            }
             
             
            System.out.println("#" + tc + " " + ans);
        } //테케 끝
    }
}