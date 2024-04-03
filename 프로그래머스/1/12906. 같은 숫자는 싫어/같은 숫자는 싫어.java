import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();
        int prevNum = -1;

        for (int curNum : arr) {
            if (curNum == prevNum) {
                continue;
            }
            list.add(curNum);
            prevNum = curNum;
        }
        
        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}