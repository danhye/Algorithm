import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<testCase;t++) {
			String[] input = br.readLine().split(" ");
			int[] arr = new int[input.length];
			
			for(int i=0;i<input.length;i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			sb.append(arr[0] + arr[1]).append("\n");
		} //테스트케이스 반복문 끝
		System.out.print(sb);
	}
}
