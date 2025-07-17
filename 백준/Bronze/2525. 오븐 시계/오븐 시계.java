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
		
		int resultHour = 0;
		int resultMin = 0;
		int overHour = (cookTime + startMin) /60;

		
		if(overHour>=1) {
			resultHour = startHour + overHour;
			resultMin = (cookTime + startMin) - (60*overHour);
			
		}else {
            resultHour = startHour;
			resultMin = startMin + cookTime;
		}
		
        //24시간
		resultHour %= 24;
        
		System.out.print(resultHour + " " + resultMin);
	}
}
