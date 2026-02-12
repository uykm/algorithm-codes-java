import java.util.*;

class Solution {
    
    static List<String> dict;
    static String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        
        dict = new ArrayList<>();
        fillDict("", 0);
        
        for (String w : dict) {
            if (w.equals(word)) {
                break;
            }
            answer++;
        }
    
        return answer;
    }
    
    static void fillDict(String word, int length) {
        dict.add(word);
        StringBuilder sb = new StringBuilder();
        if (length == 5) return;
        
        for (int i = 0; i < 5; ++i) {
            fillDict(sb.append(word).append(words[i]).toString(), length + 1);
            sb.setLength(0);
        }
            
    }
}