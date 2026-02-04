import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int cnt;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            
            graph[start].remove((Integer)end);
            graph[end].remove((Integer)start);
            
            cnt = 0;
            dfs(1);
            
            Arrays.fill(visited, false);
            answer = Math.min(answer, Math.abs((n - cnt) - cnt));
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        return answer;
    }
    
    private void dfs(int node) {
        visited[node] = true;
        cnt++;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}