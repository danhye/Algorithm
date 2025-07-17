import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 받기
		String[] input = br.readLine().split(" ");
		int startHour = Integer.parseInt(input[0]);
		int startMin = Integer.parseInt(input[1]);
		
		int cookTime = Integer.parseInt(br.readLine());
		
		int total = 0;
		int resultHour = 0;
		int resultMin = 0;
		
		total = (startHour*60) + startMin + cookTime;
		resultHour = (total / 60) % 24;
		resultMin = total % 60;
		
		System.out.print(resultHour + " " + resultMin);
	}
}
