import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //개수
        int M = Integer.parseInt(st.nextToken()); //횟수

        st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[N];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        //누적합 구하기
        int[] prefix = new int[N + 1]; //인덱스 시작 1부터 하려고 +1 했음
        for(int i = 0; i < N; i++){
            prefix[i+1] = prefix[i] + num[i];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            System.out.println(prefix[endIdx] - prefix[startIdx-1]);
        }
    }
}