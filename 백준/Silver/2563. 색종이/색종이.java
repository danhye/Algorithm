import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 전체 색종이 수
		int paper = Integer.parseInt(br.readLine());
		// 중복 범위 체크를 위해 boolean 배열 생성
		boolean[][] isVisited = new boolean[100][100]; // boolean 타입의 초기 값은 false

		for (int i = 0; i < paper; i++) {
			String[] xy = br.readLine().split(" ");
			int px = Integer.parseInt(xy[0]); // 3
			int py = Integer.parseInt(xy[1]); // 7

			// 열 행
			for (int c = px; c < px + 10; c++) {
				for (int r = py; r < py + 10; r++) {
					isVisited[c][r] = true;
				}
			}
		} // 전체 색종이 반복문 끝

		// true인 count 세기
		int count = 0;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if (isVisited[x][y]) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
