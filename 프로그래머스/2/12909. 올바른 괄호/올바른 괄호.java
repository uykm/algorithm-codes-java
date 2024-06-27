class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int zero = 0;
        for (char c : s.toCharArray()) {
            if (zero < 0) return false;
            
            if (c == '(') zero++;
            else if (c == ')') zero--;
        }
        
        if (zero != 0) answer = false;

        return answer;
    }
}