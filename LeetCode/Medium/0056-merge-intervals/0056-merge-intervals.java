class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int minStart = intervals[0][0];
        int maxEnd = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        
        for (int i = 1; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (maxEnd < start) {
                list.add(new int[]{minStart, maxEnd});
                minStart = start;
                maxEnd = end;
                continue;
            }
            maxEnd = Math.max(end, maxEnd);
        }
        list.add(new int[]{minStart, maxEnd});

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < answer.length; ++i) {
            int[] arr = list.get(i);
            answer[i][0] = arr[0];
            answer[i][1] = arr[1];
        }

        return answer;
    }
}