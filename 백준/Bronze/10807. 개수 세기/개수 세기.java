import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[st.countTokens()];
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		
		int v = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == v) {
				count++;
			}
		}
		System.out.println(count);
	}
}
