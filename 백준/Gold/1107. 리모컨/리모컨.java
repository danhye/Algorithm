import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] brokens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //이동하려고 하는 채널
        int M = Integer.parseInt(br.readLine()); //고장난 버튼의 개수
        brokens = new boolean[10];
        if(M > 0){ //고장난 버튼이 있는경우
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++){
                brokens[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // +/- 버튼으로만 이동할 경우
        int ans = Math.abs(N - 100);

        // 전체 가능한 채널을 돌면서 최소 이동 횟수를 구함
        // 채널 N (0 ≤ N ≤ 500,000) ..... 여유분
        for(int i = 0; i < 1000000; i++){
            int len = changeChannel(i); //숫자 버튼 고장나서 못 누른다면 -1
            if(len != -1){
                int change = len + Math.abs(i - N);
                if(change < ans) ans = change;
            }
        }

        System.out.println(ans);
    }

    private static int changeChannel(int channel) {
        //숫자버튼으로 눌러서 이동 가능?
        int len = 0;
        while(true) {
            int num = channel % 10;
            if (brokens[num]) return -1;
            len++;
            channel /= 10;

            if(channel == 0) break;
        }
        return len;
    }
}