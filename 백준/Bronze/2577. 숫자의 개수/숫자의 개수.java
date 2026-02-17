import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String multi = String.valueOf(a * b * c);

        int[] nums = new int[10];
        for(char num : multi.toCharArray()){
            nums[Integer.parseInt(String.valueOf(num))]++;
        }

        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}