import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        String num = "666";

        while(true){
            if(cnt == N) break;

            num = String.valueOf(Integer.parseInt(num) + 1);
            if(num.contains("666")) cnt++;
        }

        System.out.println(num);
    }
}