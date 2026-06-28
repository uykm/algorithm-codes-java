class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            // num이 시작점인 경우에만 길이 계산
            if (set.contains(num - 1)) {
                continue;
            }

            int current = num;
            int len = 1;

            while (set.contains(current + 1)) {
                current++;
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}