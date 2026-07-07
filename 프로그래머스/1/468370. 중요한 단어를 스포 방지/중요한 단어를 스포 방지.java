import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int m_len = message.length();
        String[] m_array = message.split("");

        Set<String> importantwords = new HashSet<>();
        Set<String> outsidewords = new HashSet<>();

        boolean[] spoiler = new boolean[m_len];

        for(int i = 0; i < spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            for(int j = start; j <= end; j++){
                spoiler[j] = true;
            }
        }

        int idx = 0;
        while(idx < m_len){
            if(m_array[idx].equals(" ")){
                idx++;
                continue;
            }

            int start = idx;
            boolean isSpoilerWord = false;

            while(idx < m_len && !m_array[idx].equals(" ")){
                if(spoiler[idx]) isSpoilerWord = true;
                idx++;
            }

            String word = message.substring(start, idx);

            if(isSpoilerWord){
                importantwords.add(word);
            } else {
                outsidewords.add(word);
            }
        }

        importantwords.removeAll(outsidewords);

        return importantwords.size();
    }
}