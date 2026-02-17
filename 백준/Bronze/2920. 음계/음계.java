import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int play(int[] nums) {
        //ascending 체크
        boolean isAscending = true;
        int num = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num){
                num++;
            }else{
                isAscending = false;
                break;
            }
        }
        if(isAscending){return 0;}

        //descending 체크
        boolean isDescending = true;
        num = 8;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num){
                num--;
            }else{
                isDescending = false;
                break;
            }
        }
        if(isDescending){return 1;}

        return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[st.countTokens()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = play(nums); // 0이면 ascending, 1이면 descending, 2이면 mixed
        if(ans == 0) System.out.println("ascending");
        if(ans == 1) System.out.println("descending");
        if(ans == 2) System.out.println("mixed");
    }
}