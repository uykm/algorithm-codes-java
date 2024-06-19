import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = 0, sbIdx = 0;
        List<int[]> list = new ArrayList<>();
        String[] criteria = {"code", "date", "maximum", "remain"};
        
        for (int i = 0; i < criteria.length; ++i) {
            if (criteria[i].equals(ext)) extIdx = i;
            if (criteria[i].equals(sort_by)) sbIdx = i;
        }
        
        int size = 0;
        
        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
                size++;
            }
        }
        
        int[][] answer = new int[size][4];
        final int SB_IDX = sbIdx;
        
        list.sort((a, b) -> a[SB_IDX] - b[SB_IDX]);
        
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}