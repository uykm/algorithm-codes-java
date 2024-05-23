import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> player = new HashMap<>();
        
        for (String p : participant) {
            player.put(p, player.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            player.put(c, player.get(c) - 1);
        }
        
        for (String p : participant) {
            if (player.get(p) == 1) {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}