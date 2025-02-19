import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        double a = sc.nextDouble();
        double b = sc.nextDouble();
    
        double actual = a/b;
        double result = a/b;
        
        double absolute = Math.abs(actual-result);
        double relative = absolute / Math.abs(actual);
        
        if(absolute<=1e-9 || relative<=1e-9){
            System.out.print(result);
        }else{
            System.out.print("오류 발생");
        }
    }
}