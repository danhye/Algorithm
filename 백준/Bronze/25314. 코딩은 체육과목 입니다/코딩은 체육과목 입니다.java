import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<num/4;i++) {
			sb.append("long").append(" ");
		}
		 System.out.print(sb + "int");
	}
}