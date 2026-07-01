class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op2 = dq.pollLast();
                int op1 = dq.pollLast();
                int result = 0;
                switch (token) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                        result = op1 / op2;
                        break;
                }
                dq.offer(result);
            }
            else {
                dq.offer(Integer.parseInt(token));
            }
        }

        return dq.poll();
    }
}