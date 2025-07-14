import java.util.Scanner;

public class HelloWorldApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		
		//sort하기
		int temp = 0;
		
		for(int i=0;i<n-1;i++) {
			for(int j=0; j<n-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
			}
			}
		}
		
		//가운데값 구하기
		//자바 인덱스는 0부터 시작
		int mid = n/2;
		int fin = nums[mid];
		System.out.print(fin);

	}
}
