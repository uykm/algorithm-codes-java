import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();
        int[] dp = new int[elements.length]; // 이전 부분수열 합을 저장하기 위한 배열(삼중 반복 제거)
        // dp의 인덱스 = 부분 수열의 머리(head)
        
        for (int len = 1; len <= elements.length; ++len) { // 연속 부분 수열 길이
            for (int i = 0; i < elements.length; ++i) {
                dp[i] += elements[(len + i - 1) % elements.length];
                hs.add(dp[i]);
            }
        }
        
        return hs.size();
    }
}

// class Solution {
//     public int solution(int[] elements) {
//         HashSet<Integer> hs = new HashSet<>();
        
//         for (int i = 1; i <= elements.length; ++i) { // 연속 부분 수열 길이
//             int head = 0;
            
//             while (head < elements.length) { // head가 원형 수열의 끝이 되었을 때
//                 int sum = 0;
//                 int next = head;
                
//                 for (int j = 0; j < i; ++j) {
//                     sum += elements[(next++) % elements.length];   
//                 }
//                 hs.add(sum);
                
//                 head++;
//             }
//         }
        
//         return hs.size();
//     }
// }