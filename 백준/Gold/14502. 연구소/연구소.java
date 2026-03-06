import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int max = 0;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void makeWall(int count, int start) {
        if (count == 3) {
            int[][] map = copy();
            spreadVirus(map);
            max = Math.max(max, countSafe(map));
            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;
            if (map[r][c] == 0) {
                map[r][c] = 1;
                makeWall(count + 1, i + 1);
                map[r][c] = 0;
            }
        }
    }

    static void spreadVirus(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();

        // 모든 바이러스 위치 추가
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 2)
                    queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (map[nr][nc] == 0) {
                    map[nr][nc] = 2;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    static int[][] copy() {
        int[][] copied = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copied[i][j] = map[i][j];
            }
        }
        return copied;
    }

    static int countSafe(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0) cnt++;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0, 0);

        System.out.println(max);
    }
}