class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int maxLen = 0;
        if (nums.length == 0) {
            return maxLen;
        }

        int tmpLen = 1;
        for (int i = 1; i < nums.length; ++i) {
            int diff = Math.abs(nums[i] - nums[i-1]);
            if (diff == 1) {
                tmpLen++;
            }
            else if (diff == 0) { // 같은 숫자 등장
                continue;
            }
            else {
                maxLen = Math.max(maxLen, tmpLen);
                tmpLen = 1;
            }
        }

        maxLen = Math.max(maxLen, tmpLen);

        return maxLen;
    }
}