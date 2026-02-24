import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            String st = br.readLine();

            Deque<Character> dq = new ArrayDeque<>();
            String ans = "YES";

            for(char c : st.toCharArray()){
                if(c == '('){
                    dq.add('(');
                }
                else{
                    if(!dq.isEmpty()){
                        dq.pollLast();
                    }else{
                        ans = "NO";
                        break;
                    }
                }
            }
            if(!dq.isEmpty()) ans = "NO";
            System.out.println(ans);
        }
    }
}