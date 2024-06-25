class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력
        int demandTime = bandage[0]; // 시전 시간 -> 추가 회복을 하기 위해 필요한 연속 회복 횟수
        int healPerSec = bandage[1]; // 1초당 회복량
        int plusHeal = bandage[2]; // 붕대를 연속으로 감았을 때 추가 회복량
        int currentTime = 0; // 현재 시간
        
        for (int[] attack : attacks) {
            int healingTime = attack[0] - currentTime - 1; // 다음 공격까지 회복할 수 있는 시간 -> 횟수
            health = Math.min(maxHealth, health + (healPerSec * healingTime));
            if (healingTime / demandTime > 0) {
            	// healingTime/demandTime : 공격 전에 연속으로 붕대 감을 수 있는 횟수
            	health = Math.min(maxHealth, health + plusHeal * (healingTime / demandTime));
            }
            
            health -= attack[1]; // 이번 공격의 피해량만큼 체력 감소
            currentTime = attack[0]; // 현재 시간을 이번에 공격한 시간으로 갱신
            if (health <= 0) return -1; // 피가 0 이하가 되어 죽은 경우
        }
        
        return health;
    }
}
// class Solution {
//     public int solution(int[] bandage, int health, int[][] attacks) {
//         int curHealth = health;
//         int demandTime = bandage[0];
//         int healPerSec = bandage[1];
//         int plusHeal = bandage[2];
//         int healingTime = 0;
//         boolean isDead = false;
//         int currentTime = 0;
        
//         for (int i = 0; i < attacks.length; ++i) {
//             int damage = attacks[i][1]; // 다음 공격의 피해량
//             int nextAttackTime = (i > 0 ? attacks[i][0] - attacks[i-1][0] : attacks[0][0]); // 다음 공격까지 힐할 수 있는 시간
//             // 다음 공격을 받을 때까지 "붕대 감기" 시전
//             for (int j = 1; j <= nextAttackTime; ++j) {
//                 if (j == nextAttackTime) { // 공격 당한 경우
//                     healingTime = 0;
//                     curHealth -= damage;
                    
//                     if (curHealth <= 0) { // 피가 0이 된 경우
//                         isDead = true;
//                         break;
//                     }
//                     continue;
//                 }
                
//                 healingTime++; // 붕대 감기 시간 1초 증가
//                 curHealth += healPerSec; // 초당 회복
    
//                 if (healingTime == demandTime) { // 연속으로 붕대 감기 성공
//                     healingTime = 0;
//                     curHealth += plusHeal; // 추가 회복
//                 }
                
//                 if (curHealth > health) { // 최대 체력을 넘긴 경우
//                     curHealth = health;
//                 }
//             }
            
//             if (isDead) { // 피가 0이 됐는지 체크
//                 curHealth = -1;
//                 break;
//             }
//         }
        
//         return curHealth;
//     }
// }