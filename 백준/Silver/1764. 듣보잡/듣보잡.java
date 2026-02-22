import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]); // 듣도 못한 사람의 수
        int M = Integer.parseInt(NM[1]); // 보도 못한 사람의 수

        Set<String> unHear = new HashSet<>();
        for(int i = 0; i < N; i++) {
            unHear.add(br.readLine());
        }

        int cnt = 0;
        List<String> unHearAndSeen = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String st = br.readLine();
            if(unHear.contains(st)) {
                cnt++;
                unHearAndSeen.add(st);
            }
        }

        Collections.sort(unHearAndSeen);

        System.out.println(cnt);

        for(int i = 0; i < unHearAndSeen.size(); i++) {
            System.out.println(unHearAndSeen.get(i));
        }

    }
}