import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> hsmp = new HashMap<>();
        for (int order = 0; order < keymap.length; ++order) {
            int cnt = 0;
            for (char c : keymap[order].toCharArray()) {
                cnt++;
                if (hsmp.getOrDefault(c, cnt) >= cnt) {
                    hsmp.put(c, cnt);
                }
            }
        }
        
        int i = 0;
        for (String target : targets) {
            for (char c : target.toCharArray()) {
                if (hsmp.containsKey(c)) {
                    answer[i] += hsmp.get(c);
                    continue;
                }
                answer[i] = -1;
                break;
            }
            i++;
        }
        
        return answer;
    }
}