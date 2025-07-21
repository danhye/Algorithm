import java.io.IOException;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
        
        //가변적인 크기를 갖는 참조자료형을 사용해보자 ( 정수형 가변적인 참조자료형 BigInteger)
		BigInteger a = scanner.nextBigInteger();
		BigInteger b = scanner.nextBigInteger();
		
		//a와 b를 합하여 출력해보세요.
		// System.out.println(a+b);
        // BigInteger는 명령어 안에서 연산 불가 
        
        System.out.println(a.add(b));
	}
}