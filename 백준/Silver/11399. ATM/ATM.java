import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> p = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            p.add(Integer.parseInt(st.nextToken()));
        }
        p.sort(null);

        int sum = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sum += p.get(j);
            }
        }
        
        System.out.println(sum);
    }
}