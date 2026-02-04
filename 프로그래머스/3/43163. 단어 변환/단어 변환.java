import java.util.*;

class Solution {
    
    static class Node {
        String word;
        int depth;
        
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(begin, 0));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.word.equals(target)) {
                return current.depth;
            }
            
            for (int i = 0; i < n; ++i) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.depth + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean canConvert(String cur, String next) {
        int diff = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)) {
                diff++;
            }
        }
        return diff == 1; // 1글자만 다르면 변환 가능
    }
    
}