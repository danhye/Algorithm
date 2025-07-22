import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int change = 1000 - input;
		
//		//풀이 1
//		int coin = 0;
//		
//		if(change/500>=1) {
//			coin += (change/500);
//		}
//		if((change%500)/100>=1) {
//			coin += (change%500)/100;
//		}
//		if((change%100)/50>=1) {
//			coin += (change%100)/50;
//		}
//		if((change%100)/10>=1) {
//			coin += (change)/10;
//		}
//		if((change%10)/5>=1) {
//			coin += (change%10)/5;
//		}
//		if((change%5)/1>=1) {
//			coin += (change%5)/1;
//		}
//		
//		System.out.println(coin);
		
		//풀이2
		int[] coins = {500,100,50,10,5,1};
		int count = 0;
		
		for(int coin:coins) {
			count += change/coin;
			change %= coin;
		}
		
		System.out.println(count);
	}
}
