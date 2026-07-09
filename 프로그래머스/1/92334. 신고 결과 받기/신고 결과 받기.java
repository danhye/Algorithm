import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;

        // String id를 int로 변환
        Map<String, Integer> id_to_idx = new HashMap<>();
        int num = 0;
        for(int i = 0; i < n; i++){
            id_to_idx.put(id_list[i], num++);
        }

        // 신고 대상 별 신고자 목록
        Map<Integer, Set<Integer>> list = new HashMap<>();
        for(int i = 0; i < report.length; i++){
            String[] st = report[i].split(" ");
            String reporter = st[0]; // 신고자
            String reported = st[1]; // 신고 대상

            int reporter_idx = id_to_idx.get(reporter); // 신고자
            int reported_idx = id_to_idx.get(reported); // 신고 대상

            if(!list.containsKey(reported_idx)){
                list.put(reported_idx, new HashSet<>());
            }
            list.get(reported_idx).add(reporter_idx);
        }

        int[] answer = new int[n];
        for(Set<Integer> reporters : list.values()){
            if(reporters.size() >= k){
                for(int reporter : reporters){
                    answer[reporter]++;
                }
            }
        }

        return answer;
    }
}