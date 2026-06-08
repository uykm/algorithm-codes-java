import java.util.*;

class Solution {

    static int MAX = 10000;

    public int removeDuplicates(int[] nums) {

        int k = nums.length;
        int previousNum = MAX + 1;
        boolean isOver = false;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == MAX + 1) break;
            
            if (nums[i] != previousNum) {
                previousNum = nums[i];
                isOver = false;
                continue;
            } 
            else if (isOver == false) { // 두 번째 중복된 요소 발견
                isOver = true;
                continue;
            }
            
            if (isOver) {
                nums[i] = MAX + 1;
                k--;
            }
        }
        
        Arrays.sort(nums);

        return k;
    }
}