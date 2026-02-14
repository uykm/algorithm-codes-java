import java.util.*;

class Solution {
    
    static List<String> paths;
    static boolean[] isUsed;
    
    public String[] solution(String[][] tickets) {
        paths = new ArrayList<>();
        isUsed = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(paths);
        
        return paths.get(0).split(" ");
    }
    
    static void dfs(int depth, String now, String path, String[][] tickets) {
        if (depth == tickets.length) {
            paths.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; ++i) {
            if (isUsed[i]) continue;
            if (now.equals(tickets[i][0])) {  // 현재(이전 도착지)에서 쓸 수 있는 티켓인지
                isUsed[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                isUsed[i] = false;
            }
        }
    }
}