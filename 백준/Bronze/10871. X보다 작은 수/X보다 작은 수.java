import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nx = br.readLine().split(" ");
		int n = Integer.parseInt(nx[0]);
		int x = Integer.parseInt(nx[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[st.countTokens()];
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[arr.length];
		idx = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < x) {
				result[idx++] = arr[i];
			}
		}
		
		for (int j = 0; j < idx; j++) {
			System.out.print(result[j] + " ");
		}
		
		
	}
}
