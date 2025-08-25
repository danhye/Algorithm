import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		String n = input[0];
		int b = Integer.parseInt(input[1]);
		
		int res = 0;
		for (int i = 0; i < n.length(); i++) {
			char ch = n.charAt(i);
			int digit;
			
			if('0' <= ch && ch <= '9') {
				digit = ch - '0';
			}else {
				digit = ch - 'A' + 10;
			}
			
			res = res * b + digit; 
		}
		
		System.out.println(res);

	}
}
