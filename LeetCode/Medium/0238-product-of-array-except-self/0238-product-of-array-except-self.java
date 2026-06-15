class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int tmp = 1;
        for (int i = 0; i < nums.length; ++i) {
            answer[i] = tmp;
            tmp *= nums[i]; 
        }

        tmp = 1;
        for (int i = nums.length-1; i >= 0; --i) {
            answer[i] *= tmp;
            tmp *= nums[i];
        }
        
        return answer;
    }
}