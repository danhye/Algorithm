import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > max) {
				max = num;
				idx = i;
			}
		}
		System.out.print(max + "\n" + (idx+1));
	}
}
