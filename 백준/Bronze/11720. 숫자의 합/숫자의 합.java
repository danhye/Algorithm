import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("");
		
		int[] nums = new int[n];
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(input[i]);
			sum += nums[i];
		}
		System.out.println(sum);
	}}
