import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 	int total = Integer.parseInt(br.readLine());
		 	int testCase = Integer.parseInt(br.readLine());
		 	
		 	//가격 합 누적
		 	StringBuilder sb = new StringBuilder();
		 	int result = 0;
		 	
		 	for(int t=0;t<testCase;t++) {
		 		String[] recipt = br.readLine().split(" ");
		 		int prize = Integer.parseInt(recipt[0]);
		 		int count = Integer.parseInt(recipt[1]);
		 		
		 		result += prize * count;
		 	}//테스트케이스 반복문 끝
		 	
		 	// 입력 총 금액과 계산 결과가 일치한 지 확인
		 	if(total==result) {
		 		System.out.println("Yes");
		 	}else {
		 		System.out.println("No");
		 	}
		 		
	}
}