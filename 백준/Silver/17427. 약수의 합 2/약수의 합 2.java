import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //24
		// f(A) 자연수 A의 약수의 합 = A의 모든 약수를 더한 값
		// x보다 작거나 같은 모든 자연수 y의 f(y) 값을 더한 값은 = g(x)
		
		long ans = 0L;
		for(int d = 1; d <= N; d++) {
			ans += (long)d * (N / d);
		}
		System.out.println(ans);
	}
}
