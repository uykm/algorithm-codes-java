import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        
        Arrays.sort(people);
        
        int start = 0, end = people.length - 1; // 투 포인터 알고리즘
        
        while (start < end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
                boat++;
            } else {
                end--;
                boat++;
            }
            
            if (start == end) { // 혼자 남은 사람
                boat++;
            }
        }
        
        return boat;
    }
}