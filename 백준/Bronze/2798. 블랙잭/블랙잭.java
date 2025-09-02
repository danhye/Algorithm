import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] cards;
	static int similarM;
	
	private static void blackjack() {
		
		//뒤에서부터 탐색할래
		out : 
		for (int i = N-1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				for (int k = j - 1; k >= 0; k--) {
					int sum = cards[i] + cards[j] + cards[k];
					if(sum == M) {
						similarM = sum;
						break out;
					}
					
					//M을 넘는 경우는 제외
					if(sum > M) continue;
					else {
						int a = Math.abs(M - sum);
						int b = Math.abs(M - similarM);
						
						if(a < b) similarM = sum;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N : 카드 장 수
		//N장의 카드 중 3장의 카드 골라야 함
		//M : 카드의 최대 합
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		blackjack();
		
		System.out.println(similarM);
	}
}
