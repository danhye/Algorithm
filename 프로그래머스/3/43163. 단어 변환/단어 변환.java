import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int diff(String a, String b){
        int res = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) res++;
        }

        return res;
    }

    public int bfs(String[] words, String begin, String target){
        boolean[] isVisited = new boolean[words.length];
        Queue<String> q = new ArrayDeque<>();
        int cnt = 0;
        String curr = null;
        q.add(begin);

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                curr = q.poll();
                if(curr.equals(target)) return cnt;
                for(int i = 0; i < words.length; i++){
                    if(!isVisited[i] && diff(curr, words[i]) == 1) {
                        isVisited[i] = true;
                        q.add(words[i]);
                    }
                }
            }
            cnt++;
        }
        return (curr.equals(target)) ? cnt : 0;
    }

    public int solution(String begin, String target, String[] words) {
        int answer =  bfs(words, begin, target);
        return answer;
    }
}
