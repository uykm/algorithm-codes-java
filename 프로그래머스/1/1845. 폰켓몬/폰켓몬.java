import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int oneHalf = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        
        return set.size() > oneHalf ? oneHalf : set.size();
    }
}