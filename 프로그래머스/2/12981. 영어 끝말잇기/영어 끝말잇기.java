import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        String head = "";
        String tail = "";

        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 1; i < words.length + 1; ++i) {
            head = words[i - 1].split("")[0]; // 현재 단어의 첫 글자
            System.out.println("단어: " + head);
            if (map.containsKey(words[i - 1])                   // 중복된 단어가 아닌지
                || (!head.equals(tail) && i > 1)) {   // 이전 단어의 마지막 글자와 이어지는지
                boolean isLast = false;
                if (i % n == 0) {
                    isLast = true;
                }
                answer[0] = isLast ? i % n + n : i % n; // 가장 먼저 탈락하는 사람 번호
                answer[1] = isLast ? i / n : i / n + 1; // 자신의 몇 번째 차례에 탈락하는지
                System.out.println("잘못된 단어 위치: " + i);
                break;
            } else {
                System.out.println("tail: " + tail);
                tail = words[i - 1].split("")[words[i - 1].length() - 1]; // 이전 단어의 마지막 글자
                map.put(words[i - 1], i);   
            }
        }

        return answer;
    }
}