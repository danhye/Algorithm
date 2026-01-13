import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while(N > 0){ //0이랑 같거나 작아지면 out
            if(N % 5 == 0){
                count += N / 5;
                N %= 5;
                break;
            }
            //5로 안나눠지면 -3
            N -= 3;
            count++;
        }

        if(N != 0) count = -1;
        System.out.println(count);
    }
}