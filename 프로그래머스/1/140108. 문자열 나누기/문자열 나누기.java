import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = ' ';
        int xCnt = 0;
        int notXCnt = 0;
        
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        
        while(!queue.isEmpty()) {
            if(xCnt == notXCnt && x != ' ') {
                x = ' ';
                answer++;
                continue;
            }
            
            if (x == ' ') {
                x = queue.poll();
                xCnt++;
                continue;
            }
            
            char tmp = queue.poll();
            
            if(tmp == x) {
                xCnt++;
            } else {
                notXCnt++;
            }
        }
        
        answer++;

        
        return answer;
    }
}