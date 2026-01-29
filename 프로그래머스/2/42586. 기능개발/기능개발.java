import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; ++i) {
            queue.add(i);
        }
        
        int start = 0;
        while (queue.size() > 0) {
            for (int i = start; i < progresses.length; ++i) {
                progresses[i] += speeds[i];
            }
            
            int cnt = 0;
            while (queue.size() > 0 && progresses[queue.peek()] >= 100) {
                queue.poll();
                cnt++;
            }
            
            
            if (cnt > 0) answer.add(cnt);
            start = cnt;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}