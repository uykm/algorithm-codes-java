class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;
        int demandTime = bandage[0];
        int healPerSec = bandage[1];
        int plusHeal = bandage[2];
        int healingTime = 0;
        boolean isDead = false;
        int currentTime = 0;
        
        for (int i = 0; i < attacks.length; ++i) {
            int damage = attacks[i][1]; // 다음 공격의 피해량
            int nextAttackTime = (i > 0 ? attacks[i][0] - attacks[i-1][0] : attacks[0][0]); // 다음 공격까지 힐할 수 있는 시간
            // 다음 공격을 받을 때까지 "붕대 감기" 시전
            for (int j = 1; j <= nextAttackTime; ++j) {
                if (j == nextAttackTime) { // 공격 당한 경우
                    healingTime = 0;
                    curHealth -= damage;
                    
                    if (curHealth <= 0) { // 피가 0이 된 경우
                        isDead = true;
                        break;
                    }
                    continue;
                }
                
                healingTime++; // 붕대 감기 시간 1초 증가
                curHealth += healPerSec; // 초당 회복
    
                if (healingTime == demandTime) { // 연속으로 붕대 감기 성공
                    healingTime = 0;
                    curHealth += plusHeal; // 추가 회복
                }
                
                if (curHealth > health) { // 최대 체력을 넘긴 경우
                    curHealth = health;
                }
            }
            
            if (isDead) { // 피가 0이 됐는지 체크
                curHealth = -1;
                break;
            }
        }
        
        return curHealth;
    }
}