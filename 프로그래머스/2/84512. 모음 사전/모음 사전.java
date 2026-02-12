import java.util.*;

class Solution {
    
    static List<String> dict;
    static String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        
        dict = new ArrayList<>();
        fillDict(new StringBuilder(), 0);
        
        for (String w : dict) {
            if (w.equals(word)) {
                break;
            }
            answer++;
        }
    
        return answer;
    }
    
    static void fillDict(StringBuilder sb, int length) {
        dict.add(sb.toString());
        if (length == 5) return;

        for (int i = 0; i < 5; ++i) {
            sb.append(words[i]);
            fillDict(sb, length + 1);
            sb.deleteCharAt(sb.length() - 1); // 되돌리기
        }
    }
}