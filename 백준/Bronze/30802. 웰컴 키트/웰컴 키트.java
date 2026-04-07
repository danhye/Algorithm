import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] size = new int[6]; // s m l xl xxl xxxl
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < size.length; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tCnt = 0;
        for (int i = 0; i < size.length; i++) {
            int quo = size[i] / T;

            if((size[i] % T) > 0 || (size[i] > 0 && size[i] < T)){
                quo+=1;
            }
            tCnt += quo;
        }

        int pCnt = N / P;
        int pieceCnt = N % P;

        StringBuffer sb = new StringBuffer();
        sb.append(tCnt).append("\n").append(pCnt).append(" ").append(pieceCnt);

        System.out.println(sb);
    }
}