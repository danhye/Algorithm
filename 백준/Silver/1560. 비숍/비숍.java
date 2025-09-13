import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        BigInteger ONE = BigInteger.ONE;
        BigInteger TWO = new BigInteger("2");

        if (N.equals(ONE)) {
            System.out.println("1");
        } else {
            //(N − 1) × 2 = 2N - 2
            BigInteger ans = N.subtract(ONE).multiply(TWO);
            System.out.println(ans);
        }
    }
}
