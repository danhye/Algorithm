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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.addLast(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> tmp = new ArrayDeque<>();

        int seq = 1; //들어갈 숫자

        while (!dq.isEmpty()) {
            //현재 줄서는 곳 확인
            if (dq.peekFirst() == seq) {
                dq.pollFirst();
                seq++;
            } else {
                tmp.addLast(dq.pollFirst());
            }
            //대기열 확인
            while (!tmp.isEmpty() && tmp.peekLast() == seq) {
                tmp.pollLast();
                seq++;
            }
        }

        // dq는 끝 tmp 한번 더 확인
        while (!tmp.isEmpty() && tmp.peekLast() == seq) {
            tmp.pollLast();
            seq++;
        }

        //출력
        System.out.println((tmp.isEmpty()) ? "Nice" : "Sad");
    }
}