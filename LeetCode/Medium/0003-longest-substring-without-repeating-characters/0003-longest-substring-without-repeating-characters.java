class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            // 중복 문자가 등장한 가장 마지막 인덱스 다음으로 start 이동
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= start) {
                start = lastIndex.get(c) + 1;
            }

            lastIndex.put(c, end);

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}