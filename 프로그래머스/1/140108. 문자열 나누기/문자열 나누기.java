import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = ' ';
        int xCnt = 0; int notXCnt = 0;
        
        for (char ch : s.toCharArray()) {
            if (x == ' ') {
                x = ch;
                xCnt++;
            } else if(x == ch) {
                xCnt++;
            } else {
                notXCnt++;
            }
            
            if (xCnt == notXCnt && x != ' ') {
                x = ' ';
                xCnt = 0; notXCnt = 0;
                answer++;
            }
        }
        
        if(xCnt != 0) answer++;

        return answer;
    }
}