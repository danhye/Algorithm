import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ans;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //종료조건
            if(a == 0 && b == 0 && c == 0) break;
            //가장 긴 변 찾기
            int max = Integer.max(a, (Integer.max(b, c)));
            //변 재정의
            int newA = 0;
            int newB = 0;
            if(a == max){
                newA = b; newB = c;
            }else if(b == max){
                newA = a; newB = c;
            }else if(c == max){
                newA = a; newB = b;
            }

            if((max * max) == (newA * newA) + (newB * newB)){
                ans = "right";
            }else{
                ans = "wrong";
            }

            System.out.println(ans);
        }
    }
}