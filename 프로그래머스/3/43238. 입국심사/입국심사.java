class Solution {
    
    static long minTime = Long.MAX_VALUE;
    static long maxTime = 0;
    
    public long solution(int n, int[] times) {
        
        for (int i = 0; i < times.length; i++) {
            maxTime = Math.max(maxTime, times[i]);
        }
        
        return findMinTime(n, times);
    }
    
    static long findMinTime(int n, int[] times) {
        long start = 0;
        long end = maxTime * n;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long personCnt = 0;
            for (int time : times) {
                personCnt += mid / time;
                if (personCnt >= n) break; // 오버플로우 방지
            }
            
            if (personCnt < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                minTime = Math.min(minTime, mid);
            }
        }
        
        return minTime;
    }
    
    
}