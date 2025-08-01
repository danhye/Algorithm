import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[n];
		int i,j,k;
		for (int a = 0; a < m; a++) {
			StringTokenizer ijk = new StringTokenizer(br.readLine()," ");
			i = Integer.parseInt(ijk.nextToken());
			j = Integer.parseInt(ijk.nextToken());
			k = Integer.parseInt(ijk.nextToken());
			
			for (int b = i-1; b <  j; b++) {
				basket[b] = k;
			}
		}
		
		for (int c = 0; c < basket.length; c++) {
			System.out.print(basket[c] + " ");
		}
	}
}
