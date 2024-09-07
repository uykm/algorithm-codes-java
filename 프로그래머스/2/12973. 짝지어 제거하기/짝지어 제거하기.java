import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == ch) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        
        if (stack.empty()) return 1;

        return 0;
    }
}