class Solution {
    public int[] solution(int[][] edges) {
        // 입력 예시 : [[2, 3], [4, 3], [1, 1], [2, 1]]
        //최대 정점 번호 찾기
        int max = Integer.MIN_VALUE;
        for(int[] e : edges){
            if(e[0] > max) max = e[0];
            if(e[1] > max) max = e[1];
        }
        
        int n = max + 1;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        boolean[] isVisited = new boolean[n]; //유령 정점 확인용
        
        for(int[] e : edges){
            outdegree[e[0]]++;
            indegree[e[1]]++;
            isVisited[e[0]] = isVisited[e[1]] = true;
        }
        
        //시작 정점 찾기
        //시작 정점 indegree = 0 && outdegree >= 2
        int start = 0;
        for(int i = 0; i < n; i++){
            if(isVisited[i] && indegree[i] == 0 && outdegree[i] >= 2){
                start = i;
                break;
            }
        }
        
        //전체 그래프의 수 = 시작 정점의 나간 간선 수
        int total = outdegree[start];
        
        //막대그래프 ? 
        //끝점 있음, outdegree = 0 인 1개의 정점
        int bar = 0;
        
        //8자그래프 ?
        //두 사이클(순환) 하나의 정점에서 만난다
        //그래서 outdegree = 2 1개 / 나머지 outdegree = 1
        int eight = 0;
        
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i] || i == start) continue;
            else if(outdegree[i] == 0) bar++;
            else if(outdegree[i] == 2) eight++;
        }

        //도넛그래프 ?
        int donut = total - (bar + eight);
        
        int[] answer = { start, donut, bar, eight};
        return answer;
    }
}