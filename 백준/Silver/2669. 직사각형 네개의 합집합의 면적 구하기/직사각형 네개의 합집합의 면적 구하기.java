import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// boolean 배열 생성
		boolean[][] isVisited = new boolean[100][100];
		int sum = 0;

		for (int i = 0; i < 4; i++) {
			String[] input = br.readLine().split(" ");
			int xStart = Integer.parseInt(input[0]);
			int xEnd = Integer.parseInt(input[2]);
			int yStart = Integer.parseInt(input[1]);
			int yEnd = Integer.parseInt(input[3]);

			// 열 행 x y
			for (int x = xStart; x < xEnd; x++) {
				for (int y = yStart; y < yEnd; y++) {
					isVisited[y][x] = true;
				}
			}
		} // for문 끝

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (isVisited[i][j])
					sum++;
			}
		}
		System.out.println(sum);
	}
}
