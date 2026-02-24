import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String operator = st.nextToken();

            if (operator.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                dq.add(num);
            }
            else if (operator.equals("pop")) {
                if (!dq.isEmpty()) sb.append(dq.pollLast()).append("\n");
                else sb.append("-1").append("\n");
            }
            else if (operator.equals("size")) sb.append(dq.size()).append("\n");
            else if (operator.equals("empty")) {
                if (dq.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if (operator.equals("top")) {
                if (dq.isEmpty()) sb.append("-1").append("\n");
                else sb.append(dq.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}