import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스위치의 개수
		int n = Integer.parseInt(br.readLine());
		// 스위치의 상태
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int student = Integer.parseInt(br.readLine());
		for (int s = 0; s < student; s++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int who = Integer.parseInt(st2.nextToken());
			int which = Integer.parseInt(st2.nextToken());

			// 남자일 경우
			if (who == 1) {
				// which의 배수이면 스위치 변경
				int num = 1;

				while (which * num < n + 1) {
					if (arr[which * num] == 0)
						arr[which * num] = 1;
					else
						arr[which * num] = 0;
					num++;
				}
			} else { // 여자일 경우
				// which 중심으로 좌우 대칭하는 구간 내 모든 스위치 변경
				// 내 스위치는 무조건 변경
				if (arr[which] == 0)
					arr[which] = 1;
				else
					arr[which] = 0;

				for (int i = 1; i < n + 1; i++) {
					// 배열이 벗어났을 때는 ... 어떻게?
					if (which - i <= 0 || which + i > n)
						break;

					if (arr[which - i] == arr[which + i]) {
						if (arr[which - i] == 0) {
							arr[which - i] = 1;
							arr[which + i] = 1;
						} else {
							arr[which - i] = 0;
							arr[which + i] = 0;
						}
					} else
						break;
				}
			} // 성별 if문 끝

		} // 학생수 반복문 끝

		// 출력
		for (int i = 1; i < n + 1; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}// main 끝
}
