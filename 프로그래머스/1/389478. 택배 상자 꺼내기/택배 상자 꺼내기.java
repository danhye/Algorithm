class Solution {
    static int nx, ny;

    public void isTarget(int box, int num, int x, int y){
        if(box == num) {
            nx = x; ny = y;
        }
    }

    public int solution(int n, int w, int num) {

        // 2차원 배열 생성하기
        // 높이값 구하기
        int h;
        if(n % w != 0)  h = n / w + 1;
        else h = n / w;

        int[][] boxs = new int[h][w];

        // 택배 쌓기
        int box = 1;
        
        out: 
        for(int i = 0; i < h; i++){
            // 인덱스가 짝수이면 오른쪽으로 쌓기
            if(i % 2 == 0){
                for(int j = 0; j < w; j++){
                    isTarget(box, num, i, j);
                    boxs[i][j] = box++;
                    if(box > n) break out;
                }
            }
            if(i % 2 != 0){ // 인덱스가 홀수이면 왼쪽으로 쌓기
                for(int j = (w-1); j >= 0; j--){
                    isTarget(box, num, i, j);
                    boxs[i][j] = box++;
                    if(box > n) break out;
                }
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(boxs[i][j]);
            }
            System.out.println();
        }

        // 택배 빼기
        int answer = 0;
        if(boxs[h-1][ny] != 0){
            answer = (h-1) - nx + 1;
        }else{
            answer = (h-1) - nx;
        }

        return answer;
    }
}