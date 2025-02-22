public class Main {
	public static void main(String[] args){
		
		String[] catArray = {
				"\\    /\\",
				" )  ( ')",
				"(  /  )",
				" \\(__)|"
		};
		// +) StringBuilder[] 배열로도 저장할 수 있다 !
		// String은 immutable이라 변경마다 새로운 객체로 생성 됨.
		// 문자열을 동적으로 수정해야 할 경우 StringBuilder[] 이 더 적합
		
		StringBuilder sb = new StringBuilder();
		
		for(String line:catArray) {
			sb.append(line).append("\n");
		}
		
		System.out.print(sb.toString());
	}		
}
