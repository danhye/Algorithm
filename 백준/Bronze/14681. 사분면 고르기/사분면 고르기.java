import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float x = Float.parseFloat(br.readLine());
        float y = Float.parseFloat(br.readLine());

        if(x>=0&&y>=0) {
            System.out.print("1");
        }else if(x<0&&y>=0){
            System.out.print("2");
        }else if(x<0&&y<0){
            System.out.print("3");
        }else{
            System.out.print("4");
        }

        br.close();
    }
}