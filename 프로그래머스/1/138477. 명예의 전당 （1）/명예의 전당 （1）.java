import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[score.length];
        
        /*
        Arrays.sort() vs Collections.sort()
        [ Worst case에서의 시간 복잡도 ]
        - Arrays.sort(): O(n^2)
        - Collections.sort(): O(n * logn)
        => 평균적으로 Collections.sort()가 효율적 
        (`Quick sort` vs `Tim sort(합병 + 삽입)`)
        */
        
        
        for (int i = 0; i < score.length; ++i) {
            
            if (i < k) list.add(score[i]);
            else {
                // k일 이후
                if (score[i] > list.get(list.size() - 1))
                    list.set(list.size() - 1, score[i]);
            }
            
            Collections.sort(list, Collections.reverseOrder());
            
            answer[i] = list.get(list.size() - 1);
        }
        
        return answer;
    }
}