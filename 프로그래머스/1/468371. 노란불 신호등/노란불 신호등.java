class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;

        // 1. 주기 계산
        int[] cycle = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cycle[i] += signals[i][j];
            }
        }

        // 2. LCM 계산
        int limit = cycle[0]; //초
        for(int i = 1; i < n; i++){
            limit = lcm(limit, cycle[i]);
        }

        // 3. 모든 신호등이 노란색인지?
        for(int time = 1; time <= limit; time++){
            boolean allYellow = true;

            for(int i = 0; i < n; i++){

                int green = signals[i][0];
                int yellow = signals[i][1];

                int pos = (time - 1) % cycle[i];

                if(!(green <= pos && pos < green + yellow)){
                    allYellow = false;
                    break;
                }
            }
            if(allYellow) return time;
        }

        return -1;
    }
    
    // 최소공배수
    public int lcm(int a, int b){
        return a / gcd(a, b) * b;
        // int 최대값 2,147,483,647
        //  * 연산 먼저하면 int 최대값을 초과하여 이상한 값으로 연산 될 가능성이 있음
        // 오버플로우를 방지하기 위하여 / 연산 먼저 처리
    }

    // 최대 공약수
    public int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}