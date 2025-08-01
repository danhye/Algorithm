import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 케이스 
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			
			// 숫자 받기
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());;
			int b = Integer.parseInt(st.nextToken());
			
			
			//출력하기
			bw.write((a+b) + "\n");
			
		}// 테스트 케이스 종료
		bw.flush();
		bw.close();
		br.close();
	}
}
