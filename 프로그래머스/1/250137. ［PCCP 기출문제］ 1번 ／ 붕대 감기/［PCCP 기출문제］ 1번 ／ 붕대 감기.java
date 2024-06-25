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
            System.out.println("[ 누적 시간 : " + attacks[i][0] + " ]");
            int nextAttackTime = (i > 0 ? attacks[i][0] - attacks[i-1][0] : attacks[0][0]);
            int damage = attacks[i][1];
            for (int j = 1; j <= nextAttackTime; ++j) {
                if (j == nextAttackTime) { // 공격 당한 경우
                    healingTime = 0;
                    curHealth -= damage;
                    System.out.println("=> 공격당함 - " + curHealth + " : " + damage + "만큼 감소");
                    // 피가 0이 된 경우
                    if (curHealth <= 0) {
                        isDead = true;
                        System.out.println("=> 사망");
                        break;
                    }
                    continue;
                }
                healingTime++; // 붕대 감기 시간 1초 증가
                System.out.println("붕대 감기 - " + healingTime + "초"); 
                System.out.print("=> " + curHealth + " -> ");
                curHealth += healPerSec; // 초당 회복
                System.out.println(curHealth + " : " + healPerSec + "만큼 회복");
                // 연속으로 붕대 감기 성공
                if (healingTime == demandTime) {
                    healingTime = 0;
                    curHealth += plusHeal; // 추가 회복
                    System.out.println("=> 연속 붕대 감기 성공 - " + curHealth + " : " + plusHeal + "만큼 회복");
                }
                // 최대 체력을 넘긴 경우
                if (curHealth > health) {
                    System.out.print("=> 최대 체력을 넘김 - " + curHealth + " -> ");
                    curHealth = health;
                    System.out.println(curHealth);
                }
                
            }
            if (isDead) {
                curHealth = -1;
                break;
            }
        }
        
        return curHealth;
    }
}