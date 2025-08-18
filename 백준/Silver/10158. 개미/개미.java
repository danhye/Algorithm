import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	//거리 : 우상 좌상 좌하 좌상 
	static final int[] dr = {1, 1, -1, 1};
	static final int[] dc = {1, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] wh = br.readLine().split(" "); 
		int w = Integer.parseInt(wh[0]); //가로 , 열
		int h = Integer.parseInt(wh[1]); //세로, 행
		
		String[] pq = br.readLine().split(" "); //시작 좌표
		int p = Integer.parseInt(pq[0]);
		int q = Integer.parseInt(pq[1]);
		
		int t = Integer.parseInt(br.readLine()); //개미가 움직일 시간
		
		//x축 처리
		int x = (p + t) % (2 * w);
		if(x > w) x = 2 * w - x;
		
		//y축 처리
		int y = (q + t) % (2 * h);
		if(y > h) y = 2 * h - y;
		
		System.out.println(x + " " + y);
		
	}
}
