// class Solution {
//     boolean solution(String s) {
//         boolean answer = true;

//         int zero = 0;
//         for (char c : s.toCharArray()) {
//             if (zero < 0) return false;
            
//             if (c == '(') zero++;
//             else if (c == ')') zero--;
//         }
        
//         if (zero != 0) answer = false;

//         return answer;
//     }
// }

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Integer> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(1);
            } else if (c == ')') {
                if (st.isEmpty()) return answer;
                else st.pop();
            }
        }

        if(st.isEmpty()) answer = true;

        return answer;
    }   

}