import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
                continue;
            }
            set.add(lotto);
        }
        
        int rank = 7;
        for (int n : win_nums) {
            if (set.contains(n)) rank--;
        }
        
        int maxRank = (rank - zeroCnt) == 7 ? 6 : (rank - zeroCnt);
        int minRank = rank == 7 ? 6 : rank;
        
        return new int[]{maxRank, minRank};
    }
}