class Solution {
    public int solution(int n, int w, int num) {

        // 2차원 배열 생성하기
        // 높이값 구하기
        int h = (n + w - 1) / w;

        int[][] boxes = new int[h][w];

        // 택배 쌓기
        int box = 1;
        int nx = 0, ny = 0;
        
        out: 
        for(int i = 0; i < h; i++){
            if(i % 2 == 0){ // 인덱스가 짝수이면 오른쪽으로 쌓기
                for(int j = 0; j < w; j++){
                    if(box == num){
                        nx = i; ny = j;
                    }
                    boxes[i][j] = box++;
                    if(box > n) break out;
                }
            }else{ // 인덱스가 홀수이면 왼쪽으로 쌓기
                for(int j = (w-1); j >= 0; j--){
                    if(box == num){
                        nx = i; ny = j;
                    }
                    boxes[i][j] = box++;
                    if(box > n) break out;
                }
            }
        }

        // 택배 빼기
        int answer = 0;
        if(boxes[h-1][ny] != 0){
            answer = (h-1) - nx + 1;
        }else{
            answer = (h-1) - nx;
        }

        return answer;
    }
}