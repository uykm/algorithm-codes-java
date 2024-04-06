import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int start = 0;
        int end = p.length();
        List<Long> list = new ArrayList<>();
        
        while (true) {
            if (end == t.length()) {
                list.add(Long.parseLong(t.substring(start)));
                break;
            }
                         
            list.add(Long.parseLong(t.substring(start, end)));
            
            start++;
            end++;
        }
        
        long[] arr = list.stream()
                        .mapToLong(i->i)
                        .toArray();
        
        long pNum = Long.parseLong(p);
        
        for (long num : arr) {
            if (num <= pNum) answer++;
        }
        
        return answer;
    }
}