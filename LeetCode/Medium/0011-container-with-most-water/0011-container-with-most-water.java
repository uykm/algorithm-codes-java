class Solution {
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int answer = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int max = (right - left) * h;
            
            answer = Math.max(answer, max);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return answer;
    }
}