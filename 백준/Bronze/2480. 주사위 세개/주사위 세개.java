import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		int prize = 0;
		
		if(a==b && b==c) {
			prize = 10000+ a * 1000;
		}else if(a==b || a==c) {
			prize = 1000 + a * 100;
		}else if(b==c) {
			prize = 1000 + b * 100;
		}else {
			int max = Math.max(a, Math.max(b, c));
			prize = max * 100;
		}
		
		System.out.print(prize);
	}
}
