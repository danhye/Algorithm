import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++){
            String st = br.readLine();
            int ans = 0;
            int num = 0;

            for(char c : st.toCharArray()){
                if(c == 'X'){
                    num = 0;
                }
                if(c == 'O'){
                    num++;
                    ans += num;
                }
            }

            System.out.println(ans);
        }

    }
}