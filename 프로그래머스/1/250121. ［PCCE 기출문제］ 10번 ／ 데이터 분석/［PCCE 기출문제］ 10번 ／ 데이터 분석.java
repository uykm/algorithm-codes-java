import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int e = 0;
        int s = 0;
        List<int[]> list = new ArrayList<>();
        
        switch (ext) {
            case "code" : 
                e = 0;
                break;
            case "date" :
                e = 1;
                break;
            case "maximum" :
                e = 2;
                break;
            case "remain" :
                e = 3;
                break;
        }
        
        int size = 0;
        
        for (int[] d : data) {
            if (d[e] < val_ext) {
                list.add(d);
                size++;
            }
        }
        
        int[][] answer = new int[size][4];
        
        switch (sort_by) {
            case "code" : 
                list.sort((a, b) -> a[0] - b[0]);
                break;
            case "date" :
                list.sort((a, b) -> a[1] - b[1]);
                break;
            case "maximum" :
                list.sort((a, b) -> a[2] - b[2]);
                break;
            case "remain" :
                list.sort((a, b) -> a[3] - b[3]);
                break;
        }
        
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}