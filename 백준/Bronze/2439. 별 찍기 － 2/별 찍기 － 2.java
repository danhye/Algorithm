import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());	
		
		for(int i=1;i<=input;i++) {
			// 공백의 갯수 input-i번 출력
			for(int j=0;j<input-i;j++) {
				System.out.print(" ");
			}
			//별의 갯수 i번 출력
			for(int k=0;k<i;k++) {
				System.out.print("*");
			}
			
			//개행
			System.out.println("");
		}
	}
}
