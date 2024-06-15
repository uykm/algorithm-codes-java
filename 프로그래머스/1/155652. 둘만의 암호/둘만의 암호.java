import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for (char sk : skip.toCharArray()) {
            skipSet.add(sk);
        }

        for (char c : s.toCharArray()) {
            int i = 0;
            char pwd = c;
            while (i < index) {
                pwd = (pwd == 'z') ? 'a' : (char)(pwd + 1);
                if (!skipSet.contains(pwd)) { 
                    i++; 
                }
            }
            sb.append(pwd);
        }
        
        return sb.toString();
    }
}
/*
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = 0;
            char pwd = c;
            while (i < index) {
                boolean doSkip = false;
                pwd = (pwd == 'z') ? pwd = 'a' : (char)(pwd + 1);
                if (!skip.contains(String.valueOf(pwd))) { i++; }
            }
            sb.append((char)pwd);
        }
        
        return sb.toString();
    }
}
*/