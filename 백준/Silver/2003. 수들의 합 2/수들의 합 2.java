import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    private static void findSumValue(int startIdx, int n, int m, int[] nums) {
        int sum = 0;
        for(int i = startIdx; i < n; i++){
            sum += nums[i];
            if(sum == m){
                count++;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //N개의 수
        int M = Integer.parseInt(st.nextToken()); //목표 합

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){ //시작점
            findSumValue(i, N, M, nums);
        }

        System.out.println(count);
    }
}