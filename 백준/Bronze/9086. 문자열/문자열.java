import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			String[] word = br.readLine().split("");
			System.out.println(word[0] + word[word.length-1]);
		}
	}
}
