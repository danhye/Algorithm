import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//학생명부 배열 생성
		int[] student = new int[30];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 28; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			student[num-1] = 1;
		}
		
		//출력
		for (int i = 0; i < student.length; i++) {
			if(student[i] == 0) System.out.println((i+1));
		}
		
	}
}
