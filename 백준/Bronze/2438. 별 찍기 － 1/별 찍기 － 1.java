import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		
		// 1행 -> 한개
		// 2행 -> 두개
		// 3행 -> 3개     n 행까지 반복 n개 출력
		for(int i=0;i<input;i++) {
			for(int j=1;j<=(i+1);j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}
}
