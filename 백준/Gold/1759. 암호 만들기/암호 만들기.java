import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder ans = new StringBuilder();
    public static void makeCode(String[] alpabet, String[] choose, int l, int vCnt, int cCnt, int cnt, int idx){
        //l개 다 골랐을 경우
        if(cnt == l){
            if(vCnt < 1 || cCnt < 2) return;
            else{
                for(int i = 0 ; i < choose.length; i++){
                    ans.append(choose[i]);
                }
                ans.append("\n");
                return;
            }
        }
        //더 고를 문자열이 없을 경우
        if(idx == alpabet.length) return;

        //idx 선택
        choose[cnt] = alpabet[idx];
        if(alpabet[idx].equals("a") || alpabet[idx].equals("e") || alpabet[idx].equals("i") || alpabet[idx].equals("o") || alpabet[idx].equals("u")){
            makeCode(alpabet, choose, l, vCnt + 1, cCnt, cnt + 1, idx + 1);
        }else{
            makeCode(alpabet, choose, l, vCnt, cCnt + 1, cnt + 1, idx + 1);
        }

        //선택 안했을때
        makeCode(alpabet, choose, l, vCnt, cCnt, cnt, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        String[] alpabet = new String[C];

        for(int i = 0; i < C; i++){
            alpabet[i] = st.nextToken();
        }
        //정렬
        Arrays.sort(alpabet);

        String[] choose = new String[L];
        makeCode(alpabet, choose, L, 0, 0, 0, 0);

        System.out.println(ans);
    }
}