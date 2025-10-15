import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nums;
	static int max, min;
	
	private static void cal(int idx ,int curVal, int plus, int minus, int multi, int div) {		
		//종료조건
		if(idx == N-1) {
			min = Math.min(min, curVal);
			max = Math.max(max, curVal);
			return;
		}
				
		//재귀
		int next = nums[idx+1];
		
		if(plus >= 1) { // +
			cal(idx+1, curVal + next, plus-1, minus, multi, div);
		}
		
		if(minus >= 1) { // -
			cal(idx+1, curVal - next, plus, minus-1, multi, div);	
		}
		
		if(multi >= 1) { // x
			cal(idx+1, curVal * next, plus, minus, multi-1, div);
		}
		
		if(div >= 1) { // %	
			if(curVal < 0) {
				int num = (curVal * -1) / next;
				cal(idx+1, num * -1, plus, minus,  multi, div-1);
			}else {
				cal(idx+1, curVal / next, plus, minus, multi, div-1);
			}
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] operator = new int[4];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
				
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		cal(0, nums[0], operator[0], operator[1], operator[2], operator[3]);
		
		System.out.println(max);
		System.out.println(min);
	}
}