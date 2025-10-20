import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while((line = br.readLine()) != null && !line.isEmpty()) {
			int n = Integer.parseInt(line.trim());// 3
			int cnt = 1; // 1의 자릿수
			int rem = 1 % n; // 1 % 3 = 1, 1의 나머지
			
			while(rem != 0) { 
				rem = (rem * 10 + 1) % n; // (1 * 10 + 1) 즉 11 % 3 ... 2
					  // 2 * 10 + 1 , 21 % 3 == 0
				cnt++;
			}
			
			System.out.println(cnt);
		}
	}
}