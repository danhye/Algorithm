import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] time = br.readLine().split(" ");
		
		int hour = Integer.parseInt(time[0]);
		int minute = Integer.parseInt(time[1]);
		
		LocalTime localTime = LocalTime.of(hour, minute);
		// * java.time 패키지 
		//  - LocalTime : 날짜가 없는 시간 (ex.LocalTime.of();, LocalTime.now(); )
		//  - LocalDate : 시간이 없는 날짜 
		//  - LocalDateTime : 날짜 + 시간
		
		//형식(H mm) 변경
        // h : 12시간 형식
        // H : 24시간 형식
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H m");
		
		//45분전 구하기
		LocalTime alramTime = localTime.minusMinutes(45);
		
		//결과 출력
		String result = alramTime.format(formatter);
		
		System.out.print(result);
	}

}
