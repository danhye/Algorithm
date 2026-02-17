import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] S = new int[21];

        int M = Integer.parseInt(br.readLine());
        //정답
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String operator = st.nextToken();

            if(operator.equals("all")){
                for(int j = 1; j < S.length; j++){S[j] = 1;}
            }
            else if(operator.equals("empty")){
                for(int j = 1; j < S.length; j++){S[j] = 0;}
            }
            else if(operator.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                S[num] = 1;
            }
            else if(operator.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                S[num] = 0;
            }
            else if(operator.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                sb.append(S[num]).append("\n");
            }
            else if(operator.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                S[num] = (S[num] == 1) ? 0 : 1;
            }
        }
        System.out.println(sb);
    }
}