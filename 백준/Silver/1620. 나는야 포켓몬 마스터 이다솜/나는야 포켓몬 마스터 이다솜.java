import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //도감에 수록되어 있는 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken()); //맞춰야하는 문제의 개수

        //포켓몬 도감
        String[] dic = new String[N+1];
        Map<String, Integer> map = new HashMap<>();

        for(int i = 1; i <= N; i++){
            dic[i] = br.readLine();
            map.put(dic[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String str = br.readLine();

            try{ //숫자일 경우
                int num = Integer.parseInt(str);
                sb.append(dic[num]).append("\n");
            }catch(NumberFormatException e){ //문자일 경우
                sb.append(map.get(str)).append("\n");
            }
        }

        System.out.println(sb);
     }
}