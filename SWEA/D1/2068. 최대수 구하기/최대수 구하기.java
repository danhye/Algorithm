import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력 한번에 하기 위해서
		StringBuilder sb = new StringBuilder(); 
		
		int testcase = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			// 테스트케이스 돌 때마다 max 값 초기화
			int max = Integer.MIN_VALUE;
			
			// 최대값 비교
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num > max) max = num;
			}
			
			//출력 모으기
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		} //test case 반복문 끝
		//한번에 출력
		System.out.print(sb.toString());
	}
}
