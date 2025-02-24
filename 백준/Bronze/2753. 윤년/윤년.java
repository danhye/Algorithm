import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int year = Integer.parseInt(br.readLine());
        
        if(isLeapYear(year)){
            System.out.print("1");
        }else{
            System.out.print("0");
        }
        
    }
    //윤년 조건 검사
    public static boolean isLeapYear(int year){
        return (year%4==0&&year%100!=0)||year%400==0;       
    }
}