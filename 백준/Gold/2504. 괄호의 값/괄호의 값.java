import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static String line;
	static Deque<Integer> dq; 
    // -1 : ( 
    // -2 : ) 
    // -3 : [ 
    // -4 : ] 
	
	private static boolean check(int curr) {
		if(dq.isEmpty()) return false;
		
		int sum = 0;		
		if(curr == -2) { // )
			while(true) {
				if(dq.isEmpty()) return false;
				int prev = dq.pollLast();
				
				if(prev == -1) { // (
					int val = (sum == 0) ? 2 : sum * 2;
					dq.addLast(val);
					return true;
				}else if(prev == -3) { // [ - 잘못된 짝
					return false;
				}else if(prev >= 0){ //숫자라면?
					sum += prev;
				}else {
					return false;
				}
			}
		}else if(curr == -4) { // ]
				while(true) {
				if(dq.isEmpty()) return false;
				int prev = dq.pollLast();
				
				if(prev == -3) { // [
					int val = (sum == 0) ? 3 : sum * 3;
					dq.addLast(val);
					return true;
				}else if(prev == -1) { // ( - 잘못된 짝
					return false;
				}else if(prev >= 0){ //숫자라면?
					sum += prev;
				}else {
					return false;
				}
			}
		}
		
		return false;
	}
 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dq = new ArrayDeque<>();
		line = br.readLine();
		
		// -1 : ( , -2 : ) , -3 : [ , -4 : ] 
		for(char c : line.toCharArray()) {
			if(c == '(') dq.addLast(-1);
			else if(c == '[') dq.addLast(-3);
			else if(c == ')') {
				if(!check(-2)) {System.out.println(0); return;}
			}
			else if(c == ']') {
				if(!check(-4)) {System.out.println(0); return;}
			}
		}//for문 끝

		
		//계산하기
		int ans = 0;
		for(int v : dq) {
			if(v < 0) {System.out.println(0); return;} //괄호가 남아있으면 잘못된 짝
			ans += v;
		}
        
		System.out.println(ans);
	}
}