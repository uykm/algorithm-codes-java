import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int maxReceivedGifts = 0;
        HashMap<String, HashMap<String, Integer>> sendMap = new HashMap<>();
        HashMap<String, Integer> friendToPoint = new HashMap<>();
        
        for (String sender : friends) {
            sendMap.putIfAbsent(sender, new HashMap<String, Integer>());
            friendToPoint.put(sender, 0);
            for (String receiver : friends) {
                if (receiver.equals(sender)) continue;
                // 선물을 주고받은 기록이 없더라도 횟수를 0으로 초기화
                sendMap.get(sender).put(receiver, 0);
            }
        }
        
        for (String gift : gifts) {
            String[] sr = gift.split(" ");
            String sender = sr[0];
            String receiver = sr[1];
            
            HashMap<String, Integer> recToCnt = sendMap.get(sender);
            recToCnt.put(receiver, recToCnt.get(receiver) + 1);
            
            friendToPoint.put(sender, friendToPoint.get(sender) + 1);
            friendToPoint.put(receiver, friendToPoint.get(receiver) - 1);
        }
        
        for (String sender : friends) {
            int nextGifts = 0;
            for (String receiver : friends) {
                if (receiver.equals(sender)) continue;
                
                int sendCnt1 = sendMap.get(sender).get(receiver); // sender -> receiver 선물 개수
                int sendCnt2 = sendMap.get(receiver).get(sender); // receiver -> sender 선물 개수
                int point1 = friendToPoint.get(sender); // sender의 선물 지수
                int point2 = friendToPoint.get(receiver); // receiver의 선물 지수
                
                if (sendCnt1 == sendCnt2) { // 주고받은 기록이 하나도 없거나 주고받은 수가 같은 경우
                    if (point1 > point2) { // sender의 선물 지수가 더 높은 경우
                        nextGifts++;
                    }
                } else if (sendCnt1 > sendCnt2) { // sender가 receiver에게 다음 달에 선물을 받아야 하는 경우
                    nextGifts++;
                }
            }
            
            maxReceivedGifts = Math.max(maxReceivedGifts, nextGifts);
        }
        
        return maxReceivedGifts;
    }
}