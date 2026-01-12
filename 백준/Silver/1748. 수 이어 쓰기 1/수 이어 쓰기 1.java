import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        //자릿수 구하기
        int len = String.valueOf(N).length();

        if(len == 1){
            ans = N;
        }else{
            ans = 9;
            // 그 전 자릿수까지만 더하기
            int num = 1;
            for(int i = 2; i < len; i++){
                num *= 10;
                ans += (9 * num) * i; // 90(갯수) * 2(자릿수)
            }
            //낱개 숫자 구하기
            int start = (int)Math.pow(10, len-1);
            ans += (N - start + 1) * len;
        }

        System.out.println(ans);
    }
}