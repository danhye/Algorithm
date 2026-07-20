class Solution {
public int solution(int[] bandage, int health, int[][] attacks) {
        // attacks 의 마지막 시간 구하기
        int lastAttack = attacks[attacks.length - 1][0];
        int i = 0, bandTime = 0;
        int preHealth = health;

        for(int t = 1; t <= lastAttack; t++){
            if(t == attacks[i][0]){ // 공격 당할 경우
                bandTime = 0;
                preHealth = Math.max(0, preHealth - attacks[i][1]);
                if (preHealth <= 0) {
                    break;
                }
                i++;
            }
            else{ // 붕대 감기
                bandTime++;
                if(bandTime == bandage[0]){
                    bandTime = 0;
                    preHealth = Math.min(health, preHealth + bandage[2]);
                }
                preHealth = Math.min(health, preHealth + bandage[1]);
            }
        }
        int answer = (preHealth == 0) ? -1 : preHealth;
        return answer;
    }
}