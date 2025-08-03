
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = (Integer.parseInt(st.nextToken())) % 42;
			//System.out.println(arr[i]);
		}
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean equal = false;
			for (int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					equal = true;
					break;
				}
			}
			if(equal == false) count++;
		}
		
		System.out.println(count);
	}
}
