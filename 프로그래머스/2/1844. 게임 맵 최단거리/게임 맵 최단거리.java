import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 1}); // r, c, 지나온 칸
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r == n - 1  && c == m - 1) return dist;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] || maps[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, dist + 1});
            }
        }
        return -1;
    }
}