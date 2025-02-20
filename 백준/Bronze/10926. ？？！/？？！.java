import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //아이디 받기
        String id = br.readLine();
        //결과 출력
        System.out.print(id + "??!");
        
        br.close();
    }
}



//대소문자, 글자수(50자 미만) 유효성 검사 버전 풀이
/*
import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static boolean isIdUpperCase(String str) {
    //소문자로 바꾼 값이랑 일치(true)한지 체크
        if(str.equals(str.toLowerCase())){
        return true;
        }else{
            return false;
        }
    }   
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String id = br.readLine();
        
        //ID 저장
        HashSet<String> idList = new HashSet<>();        
        
        //대소문자, 문자 길이 체크
        if(isIdUpperCase(id) && id.length() <= 50){
            //중복 여부 체크
            if(idList.add(id)){
                System.out.print("ID가 저장되었습니다.");
            }else{
                String result = String.format("%s??!",id);
                System.out.print(result);
            }
            
        }else{
            System.out.print("ID 형식 오류입니다.");
        }
        
        br.close();   
    }
}
*/