import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] mod = new boolean[42];
		
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine()) % 42;
			mod[num] = true;
		}
		
		int count = 0;
		for (int i = 0; i < mod.length; i++) {
			if(mod[i]) count++;
		}
		
		System.out.println(count);
	}
}
