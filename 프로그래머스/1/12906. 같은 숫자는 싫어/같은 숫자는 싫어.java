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
        
        // 메모리는 많이 잡아먹긴 하는데, 편의상 사용
        return list.stream()
            .mapToInt(i -> i) // 'mapToInt'는 객체 스트림을을 int 스트림으로 변환해주고, 람다표현식 'i -> i'는 아무 작업 X
            // 'Integer::intValue)': Object 타입을 int 타입으로 변환
            .toArray();
    }
}