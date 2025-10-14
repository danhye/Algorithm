import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 정수를 하나 외칠때마다 지금까지 말한 수 중에서 중간값을 출력
		 * 만일, 그동안 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수 출력
		 */
		//long startTime = System.nanoTime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //외치는 정수의 개수
		
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //최대힙
		PriorityQueue<Integer> right = new PriorityQueue<>(); //최소힙
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(left.isEmpty() || num <= left.peek()) left.add(num); 
			else right.add(num); 
			
			//크기
			if(left.size() < right.size()) left.add(right.poll());
			else if(left.size() > right.size() + 1) right.add(left.poll());
			
			//순서 left < right
			if(!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) right.add(left.poll());
			
			//출력	
			ans.append(left.peek()).append("\n");
		}
		
		System.out.println(ans);
		
		//long duration = System.nanoTime() - startTime;
		//System.out.println(duration / 1_000_000_000.0);
	}

}