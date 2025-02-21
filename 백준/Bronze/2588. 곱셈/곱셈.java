import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		String[] input = br.readLine().split("\n"); 
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		*/
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		//곱하기
		int digitB100 = b /100;
		int b2 = b % 100;
		int digitB10 = b2 / 10;
		int digitB1 = b2 % 10;
		
		int result1 = a * digitB1;
		int result2 = a * digitB10;
		int result3 = a * digitB100;
		int result4 = result1 + (result2 * 10) + (result3 * 100);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		
		br.close();
	}
}
