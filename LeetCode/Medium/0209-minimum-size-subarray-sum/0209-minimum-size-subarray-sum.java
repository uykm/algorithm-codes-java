class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end]; // 슬라이딩 윈도우 오른쪽으로 확장

            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++; // 슬라이딩 윈도우 왼쪽 칸 제거
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}