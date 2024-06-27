class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int max = Integer.valueOf(nums[0]), min = Integer.valueOf(nums[0]);
        for (String num : nums) {
            max = Math.max(max, Integer.valueOf(num));
            min = Math.min(min, Integer.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }
}