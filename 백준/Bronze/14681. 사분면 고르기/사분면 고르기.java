import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        // =================방법 1. if문 활용 ===============================
        /*
        if(x>=0&&y>=0) {
            System.out.print("1");
        }else if(x<0&&y>=0){
            System.out.print("2");
        }else if(x<0&&y<0){
            System.out.print("3");
        }else{
            System.out.print("4");
        }
        */
        // =================방법 2. 삼항 연산자 활용===========================
        //System.out.print((x>=0 ? (y>=0 ? 1 : 4) : (y>=0 ? 2 : 3)));

        // =================방법 3. switch문 활용=============================
        /*
        switch (x>=0 ? (y>=0 ? 1 : 4) : (y>=0 ? 2 : 3)){
            case 1:
                System.out.print("1");
                break;
            case 2:
                System.out.print("2");
                break;
            case 3:
                System.out.print("3");
                break;
            case 4:
                System.out.print("4");
                break;
        }
        */
        // =================방법 4. math.signum 함수 활용======================
        // signum : 부호 확인
        //매개변수가 양수일 경우 1.0을, 음수일 경우 -1.0을 반환
        //Math.signum 은 float 타입 반환

        int xSign = (int)Math.signum(x);
        int ySign = (int)Math.signum(y);

        System.out.print((xSign>=0 ? (ySign>=0? 1 : 4) : (ySign>=0? 2 : 3)));
        
        br.close();
    }
}