import java.util.*;

class Solution {
    static int maxVisitedCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(0, k, dungeons, visited);
        
        return maxVisitedCnt;
    }
    
    static void dfs(int visitedCnt, int energy, int[][] dungeons, boolean[] visited) {
        maxVisitedCnt = Math.max(maxVisitedCnt, visitedCnt);
        
        for (int i = 0; i < dungeons.length; ++i) {
            if (!visited[i] && energy >= dungeons[i][0]) {
                visited[i] = true;
                int requiredEnergy = dungeons[i][1];
                dfs(visitedCnt + 1, energy - requiredEnergy, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}