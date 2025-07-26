import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력값 받기
		int input = Integer.parseInt(br.readLine());
		
		//누적값 구하기
		int sum = 0;
		
		for (int i = 1; i <= input; i++) {
			sum += i;
		}
		
		//출력
		System.out.println(sum);
	}
}
