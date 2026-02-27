import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int max = Integer.MIN_VALUE; //얻을 수 있는 최대 이익

    public static void counsel(int n, int[][] schedule, int currDay, int currSum){

        if(currDay == n){
            max = Math.max(max, currSum);
            return;
        }else if(currDay > n){
            return;
        }
        
        int nextTime = currDay + schedule[currDay][0];
        int money = currSum + schedule[currDay][1];
        //선택했을 경우
        counsel(n, schedule, nextTime, money);

        //선택하지 않았을 경우
        counsel(n, schedule, currDay + 1, currSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        counsel(N, schedule, 0, 0);
        System.out.println(max);
    }
}