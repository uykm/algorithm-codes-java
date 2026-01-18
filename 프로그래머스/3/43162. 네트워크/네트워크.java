import java.util.*;

class Solution {
    
    static List<List<Integer>> network = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int networkCnt = 0;
        
        for (int i = 0; i < n; ++i) {
            network.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && computers[i][j] == 1) {
                    addEdge(i, j);
                }
            }
        }
        
        visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i);
                networkCnt++;
            }
        }
        
        return networkCnt;
    }
    
    static void dfs(int node) {
        for (int next : network.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
    
    static void addEdge(int a, int b) {
        network.get(a).add(b);
        network.get(b).add(a);
    }
    
}