import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		//바구니에 값 담기
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		//m번 반복 돌리기
		for (int a = 1; a <= m; a++) {
			//역순을 만드는 방법(ij) 받기
			StringTokenizer ij = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(ij.nextToken());
			int j = Integer.parseInt(ij.nextToken());
			
			int left = i - 1;
			int right = j - 1;
			while(left < right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
		}//m번 반복 끝
		
		//arr 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
