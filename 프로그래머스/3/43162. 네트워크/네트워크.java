class Solution {
    static boolean[] isVisited;
    static int answer;

    public void dfs(int com, int[][] computers){
        isVisited[com] = true;

        for(int i = 0; i < computers.length; i++){
            if(i != com && computers[com][i] == 1 && !isVisited[i]){
                dfs(i, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {

        isVisited = new boolean[n];
        answer = 0;

        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                dfs(i, computers);
                answer += 1;
            }
        }


        return answer;
    }
}