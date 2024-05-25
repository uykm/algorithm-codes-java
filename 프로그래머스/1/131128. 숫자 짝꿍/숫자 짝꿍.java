import java.util.*;   
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        HashMap<Character, Integer> yMap = new HashMap<>();
        
        for (char c : X.toCharArray()) {
            yMap.put(c, yMap.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (char c : Y.toCharArray()) {
            if (yMap.getOrDefault(c, 0) > 0) {
                yMap.put(c, yMap.get(c) - 1);
                list.add(c - '0');
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        ListIterator<Integer> iterator = list.listIterator();
        boolean isAllZero = false;
        while(iterator.hasNext()){
            if (iterator.next() != 0) {
                return list.stream()
                   .map(String::valueOf) // Integer를 String으로 변환
                   .collect(Collectors.joining()); // 문자열로 결합
            }
            isAllZero = true;
        }
        
        return isAllZero == true ? "0" : "-1";
    }
}