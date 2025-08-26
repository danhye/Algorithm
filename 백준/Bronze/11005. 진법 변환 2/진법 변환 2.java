import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		String res = "";
		
		//몫이 0이 될 때까지 나누고, 나머지 값을 역순으로 나열하기
		while(N > 0) {
			int digit = (int) N % B;
			if(digit >= 10) {
//				char ch = (char)(digit + 55);
				char ch = (char)('A' + (digit - 10)); 
				res += ch;
			}else {
				res += (char)(digit + '0');
			}
			
			N /= B;
		}
		
		for (int i = res.length()-1; i >= 0 ; i--) {
			System.out.print(res.charAt(i));
		}
	}
}
