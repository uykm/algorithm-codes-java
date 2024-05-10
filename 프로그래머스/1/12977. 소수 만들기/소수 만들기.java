import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i + 1; j < nums.length; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) answer++;
                }
            }
        }

        return answer;
    }
    
    public boolean isPrime(int sum) {
        for (int i = 2; i <= (int)sum / i; ++i) {
            if (sum % i == 0) {
                return false;
            }            
        }
        return true;
    }
}