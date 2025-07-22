import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());	
		
		// 1행 -> 한개
		// 2행 -> 두개
		// 3행 -> 3개     n 행까지 반복 n개 출력
		for(int i=1;i<=input;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
