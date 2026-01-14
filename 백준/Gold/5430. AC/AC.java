import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){

            //수행할 함수
            String p = br.readLine();

            //배열에 들어갈 수
            int N = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            Deque<Integer> nums = new ArrayDeque<>();

            // 숫자만 Deque 담음
            if(N > 0){
                String[] temp = arr.substring(1, arr.length()-1).split(",");
                for(String s : temp){
                    nums.add(Integer.parseInt(s));
                }
            }

            boolean isReverse = false; //실제로 뒤집지 않고 체크만!
            boolean isError = false;

            for(int i = 0; i < p.length(); i++){
                char ch = p.charAt(i);
                if(ch == 'R'){ //실행할 함수가 R (배열에 있는 수의 순서를 뒤집기) 일 경우
                    isReverse = !isReverse; //토글
                }else{ //실행할 함수가 D (첫번째 수를 버리는 함수) 일 경우
                    if(nums.isEmpty()){
                        isError = true;
                        break;
                    }
                    if(!isReverse) nums.pollFirst();
                    else nums.pollLast();
                }
            }

            //출력은 StringBuilder ...
            StringBuilder sb = new StringBuilder();
            if(isError){
               sb.append("error");
            }else{
                sb.append("[");
                while(!nums.isEmpty()){
                    sb.append(isReverse ? nums.pollLast() : nums.pollFirst());
                    if(!nums.isEmpty()) sb.append(",");
                }
                sb.append("]");
            }
            System.out.println(sb);
        } //테케 끝
    }
}