class Solution {
    public int jump(int[] nums) {
        
        int minJump = 0;
        int curMax = 0;
        int nextMax = 0;
    

        for (int i = 0; i < nums.length - 1; ++i) {
            // 현재 이동할 수 있는 최대 범위(~curMax) 내에서 
            // 가장 멀리 갈 수 있는 인덱스 위치(nextMax) 탐색
            nextMax = Math.max(nextMax, i + nums[i]);

            if (i == curMax) {  
                minJump++;
                curMax = nextMax;

                if (curMax >= nums.length - 1) break;
            }

        }

        return minJump;
    }
}