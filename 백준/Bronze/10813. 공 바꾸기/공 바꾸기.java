import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer nm = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(nm.nextToken());
		int m = Integer.parseInt(nm.nextToken());
		
		int[] basket = new int[n];
		int tmp = 0;
		int i,j;
		
		// 바구니 초기 값 넣어주기
		for (int a = 0; a < basket.length; a++) {
			basket[a] = a+1;
		}
		
		// 바구니 공 바꾸기
		for (int b = 0; b < m; b++) {
			StringTokenizer ij = new StringTokenizer(br.readLine()," ");
			i = Integer.parseInt(ij.nextToken());
			j = Integer.parseInt(ij.nextToken());
			
			tmp = basket[i-1];
			basket[i-1] = basket[j-1];
			basket[j-1] = tmp;
		}
		
		//출력
		for (int c = 0; c < basket.length; c++) {
			System.out.print(basket[c] + " ");
		}
		
	}
}
