import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 상 하 좌 우
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = line.charAt(j);
            }
        }

        // 먹을 수 있는 사탕의 최대 개수
        int max = Integer.MIN_VALUE;

        // 네 방향 모두 다 돌면서 인접한 칸 교환하고, 먹을 수 있는 사탕의 최대 개수 저장
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 범위 넘으면 나가세요
                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                    // 사탕의 색이 다르면
                    if(board[r][c] != board[nr][nc]){
                        // swap
                        char tmp = board[r][c];
                        board[r][c] = board[nr][nc];
                        board[nr][nc] = tmp;

                        // 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분 구하기
                        int cnt = count(N, board);
                        if(cnt > max) max = cnt;

                        // swap 되돌리기
                        tmp = board[r][c];
                        board[r][c] = board[nr][nc];
                        board[nr][nc] = tmp;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(max);

    }

    private static int count(int N, char[][] board) {
        int res = 0;

        // 열 세기
        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 1; j < N; j++){
                if(board[i][j] == board[i][j-1]) {
                    cnt++;
                } else{
                    // 다르면 초기화
                    cnt = 1;
                }
                if(cnt > res) res = cnt;
            }
        }

        // 행 세기
        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 1; j < N; j++){
                if(board[j][i] == board[j-1][i]) {
                    cnt++;
                }else{
                    cnt = 1;
                }
                if(cnt > res) res = cnt;
            }
        }

        return res;
    }
}