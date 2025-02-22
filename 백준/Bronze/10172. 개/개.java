public class Main {
	public static void main(String[] args){
		String[] catArray = {
				"|\\_/|",
				"|q p|   /}",
				"( 0 )\"\"\"\\",
				"|\"^\"`    |",
				"||_/=\\\\__|"
		};
        
        StringBuilder sb = new StringBuilder();
		
		for(String line:catArray) {
			sb.append(line).append("\n");
		}
		
		System.out.print(sb.toString());
	}		
}
