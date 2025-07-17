import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int first = Integer.parseInt(input[0]);
		int second = Integer.parseInt(input[1]);
		int third = Integer.parseInt(input[2]);
		int prize = 0;
		
		boolean case1 = (first==second && first==third);
		boolean case2 = (first==second || first==third || second==third ) != (first==second && second==third);
		
		
		if(case1) {
			prize = 10000+ first*1000;
		}else if(case2) {
			//어떤 두 값이 같은 지?
			if(first==second) {
				prize = 1000 + first*100;
			}else if(first==third) {
				prize = 1000 + first*100;
			}else if(second==third) {
				prize = 1000 + second*100;
			}
		}else { //3개 값이 다 다르면 max 값 찾기
			int max = first;
			if(second>max) {
				max = second;
			}
            if(third>max) {
				max = third;
			}
			
			prize = max * 100;
		}
		
		System.out.print(prize);
	}
}
