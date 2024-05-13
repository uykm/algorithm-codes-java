import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] wall = new boolean[n];
        int sectionNum = section.length;
        
        Arrays.fill(wall, true);
        
        for (int s : section) {
            wall[s-1] = false;
        }
            
        for (int i = 0; i < wall.length; ++i) {
            if (wall[i] == false) {
                for (int j = 0; j < m; ++j) {
                    if ((i + j) >= wall.length) break;
                    wall[i + j] = true;
                }                  
                i += (m-1);
                answer++;
            }
        }
        
        return answer;
    }
}