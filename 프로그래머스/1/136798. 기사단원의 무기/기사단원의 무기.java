class Solution {
    public int solution(int number, int limit, int power) {
        int weightOfIron = 0;
        
        for (int i = 1; i <= number; ++i) {
            int divCnt = divisorCount(i);
            
            if (divCnt > limit) {
                weightOfIron += power;
                continue;
            }
            weightOfIron += divCnt;
        }
        
        return weightOfIron;
    }
    
    public int divisorCount(int num) {
        int cnt = 1;
        if (num == 1) {
            return cnt;
        }
        for (int i = 1; i <= num/2; ++i) {
            if (num % i == 0) cnt += 1;
        }
        return cnt;
    }
}