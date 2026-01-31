import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) 
            pq.offer(s);
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int best = pq.poll();
            int second = pq.poll() * 2;
            int newFood = best + second;
            pq.offer(newFood);
            answer++;
        }
        
        if (pq.peek() < K) 
            return -1;
        
        return answer;
    }
}