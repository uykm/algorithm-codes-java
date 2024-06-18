import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int hamburgers = 0;

        for (int i : ingredient) {
            stack.push(i);
            if (stack.size() >= 4) {
                // 마지막 4개의 요소가 "1, 2, 3, 1"인지 확인
                if (stack.get(stack.size() - 4) == 1 &&
                    stack.get(stack.size() - 3) == 2 &&
                    stack.get(stack.size() - 2) == 3 &&
                    stack.get(stack.size() - 1) == 1) {
                    // "1231" 패턴이 발견되면 스택에서 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    hamburgers++;
                }
            }
        }
        return hamburgers;
    }
}