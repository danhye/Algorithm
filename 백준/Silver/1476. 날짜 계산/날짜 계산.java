import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken()); //1
        int S = Integer.parseInt(st.nextToken()); //2
        int M = Integer.parseInt(st.nextToken()); //3

        int res = 0;

        while(true){
            if(res % 15 + 1 == E && res % 28 + 1 == S && res % 19  + 1 == M){
                break; //탈출
            }
            res++;
        }

        //연도를 0부터 시작했으니 +1
        System.out.println(res+1);
    }
}