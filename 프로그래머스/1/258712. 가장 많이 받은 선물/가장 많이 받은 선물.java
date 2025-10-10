import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendToIndex = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendToIndex.put(friends[i], i);
        }
        
        int[] points = new int[friends.length];
        int[][] record = new int[friends.length][friends.length];
        
        for (String gift : gifts) {
            String[] rs = gift.split(" ");
            String sender = rs[0];
            String receiver = rs[1];
            
            points[friendToIndex.get(sender)]++;
            points[friendToIndex.get(receiver)]--;
            record[friendToIndex.get(sender)][friendToIndex.get(receiver)]++;
        }

       int maxGifts = 0;
        
       for (int i = 0; i < friends.length; i++) {
           int nextGifts = 0;
           
           for (int j = 0; j < friends.length; j++) {
               if(i == j) continue; // 본인인 경우
               
               // sender가 receiver에게 다음 달에 선물을 받아야 하는 경우
               if (record[i][j] > record[j][i]) {
                   nextGifts++; 
               } else if (record[i][j] == record[j][i] && points[i] > points[j]) {
                   nextGifts++; 
               }
           }
           maxGifts = Math.max(nextGifts, maxGifts);
       }
        return maxGifts;
    }
}