class Solution {
    public String simplifyPath(String path) {

        Deque<String> dq = new ArrayDeque<>();

        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals(".") || token.equals("")) {
                continue;
            }
            else if (token.equals("..")) {
                dq.pollLast();
                dq.pollLast();
            }
            else {
                dq.offerLast("/");
                dq.offerLast(token);
            }
        }

        if (dq.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        
        return sb.toString();
    }
}