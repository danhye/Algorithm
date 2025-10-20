import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarf = new int[9];
		for(int i = 0; i < 9; i++) {
			String input = br.readLine();
			dwarf[i] = Integer.parseInt(input);
		}
		
		int[] realDwarf = new int[7];
		
		for(int i = 0; i < 8; i++) {
			for(int j = i+1; j < 9; j++) {
				int sum = 0;
				for(int k = 0; k < 9; k++) sum += dwarf[k];
				sum -= (dwarf[i] + dwarf[j]);
				if(sum == 100) {
					int idx = 0;
					for(int l = 0; l < 9; l++) {
						if(l != i && l != j) {
							realDwarf[idx++] = dwarf[l];
						}
					}
					break;
				}
			}
		} //for문 끝
		
		Arrays.sort(realDwarf);
		for(int d : realDwarf) System.out.println(d);
	}
}