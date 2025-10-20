import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt  = Integer.parseInt(br.readLine()); //약수의 개수, 50보다 작거나 같다
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] factor = new int[cnt]; //약수
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < cnt; i++) {
			factor[i] = Integer.parseInt(st.nextToken());
			if(factor[i] > max) max = factor[i];
			if(factor[i] < min) min = factor[i];
		}
		
		int N = min * max;
		System.out.println(N);
	}
}