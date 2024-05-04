import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[score.length];
        
        
        for (int i = 0; i < score.length; ++i) {
            
            if (i < k) list.add(score[i]);
            else {
                if (score[i] > list.get(list.size() - 1))
                    list.set(list.size() - 1, score[i]);
            }
            
            Collections.sort(list, Collections.reverseOrder());
            
            answer[i] = list.get(list.size() - 1);
        }
        
        return answer;
    }
}