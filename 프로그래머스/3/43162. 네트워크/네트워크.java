import java.util.*;

class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n);
                cnt++;
            }
        }
        return cnt;
    }

    void dfs(int cur, int[][] computers, int n) {
        visited[cur] = true;
        for (int next = 0; next < n; next++) {
            if (computers[cur][next] == 1 && !visited[next]) {
                dfs(next, computers, n);
            }
        }
    }
}

// class Solution {
    
//     static List<List<Integer>> network = new ArrayList<>();
//     static boolean[] visited;
    
//     public int solution(int n, int[][] computers) {
//         int networkCnt = 0;
        
//         for (int i = 0; i < n; ++i) {
//             network.add(new ArrayList<>());
//         }
        
//         for (int i = 0; i < n; ++i) {
//             for (int j = i+1; j < n; ++j) {
//                 if (i != j && computers[i][j] == 1) {
//                     addEdge(i, j);
//                 }
//             }
//         }
        
//         visited = new boolean[n];
//         for (int i = 0; i < n; ++i) {
//             if (!visited[i]) {
//                 dfs(i);
//                 networkCnt++;
//             }
//         }
        
//         return networkCnt;
//     }
    
//     static void dfs(int node) {
//         visited[node] = true;
//         for (int next : network.get(node)) {
//             if (!visited[next]) {
//                 dfs(next);
//             }
//         }
//     }
    
//     static void addEdge(int a, int b) {
//         network.get(a).add(b);
//         network.get(b).add(a);
//     }
// }