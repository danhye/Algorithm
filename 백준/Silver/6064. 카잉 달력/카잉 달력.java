import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken()) -1;
            int Y = Integer.parseInt(st.nextToken()) -1;

            boolean check = false;

            for(int i = X; i < (N * M); i += M){
                if(i % N == Y) {
                    System.out.println(i + 1);
                    check = true;
                    break;
                }
            }

            if(!check) System.out.println(-1);

        } //테케 끝
    }
}