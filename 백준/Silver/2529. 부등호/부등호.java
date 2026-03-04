import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static String[] sign;
    static int[] answer;
    static boolean[] visited;

    static String min = "9999999999"; //최대 자릿수 0123456789
    static String max = "";

    static void dfs(int idx){
        if(idx == k + 1) {
            StringBuilder stringAns = new StringBuilder();
            for(int i = 0; i <= k; i++){
                stringAns.append(answer[i]);
            }
            String ans = stringAns.toString();
            if(ans.compareTo(max) > 0) max = ans;
            if(ans.compareTo(min) < 0) min = ans;
            return;
        }

        for(int i = 0; i <= 9; i++){
            if(visited[i]) continue;

            if(idx > 0){
                int prev = answer[idx-1];
                if(sign[idx-1].equals("<") && (prev > i)) continue;
                if(sign[idx-1].equals(">") && (prev < i)) continue;
            }
            visited[i] = true;
            answer[idx] = i;
            dfs(idx + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        sign = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < k; i++){
            sign[i] = st.nextToken();
        }

        answer = new int[10];
        visited = new boolean[10];

       dfs(0);

        System.out.println(max);
        System.out.println(min);
    }
}