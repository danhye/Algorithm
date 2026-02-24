import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine()); //해빈이가 가진 의상의 수
            Map<String, Integer> clothes = new HashMap<>();

            int idx = 1;

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken(); //갯수만 카운트하면 된다
                String category = st.nextToken();

                clothes.put(category, clothes.getOrDefault(category,0) + 1); //해당 category에 카운트 된 값이 없으면 0 반환 + 1, 있으면 반환 + 1
            }

            // 각 옷의 종류에서 (안입는 경우 + 하나만 입는 경우)
            // 전체 옷을 모두 안입는 경우 빼기
            int ans = 1;
            for(int cnt : clothes.values()){
                ans *= (1 + cnt);
            }
            ans -= 1;

            System.out.println(ans);
            
        } //테케 끝
    }
}