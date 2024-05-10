class Solution {
    public int solution(int number, int limit, int power) {
        int weightOfIron = 0;
        
        for (int i = 1; i <= number; ++i) {
            int divCnt = divisorCount(i);
            weightOfIron += divCnt > limit ? power : divCnt;
        }
        
        return weightOfIron;
    }
    
    public int divisorCount(int num) {
        int cnt = 0;
        for (int i = 1; i <= (int)num / i; ++i) {
			if (i * i == num) {
				cnt++;
			} else if (num % i == 0) {
		        cnt += 2;
			}
        }
        return cnt;
    }
}