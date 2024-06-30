class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
    }
}
// class Solution {
//     public int[] solution(String s) {
//         int[] answer = new int[2];
//         int zeroCnt = 0, transformCnt = 0;
        
//         while (!s.equals("1")) {
//             int length = s.length();
//             for (char c : s.toCharArray()) {
//                 if (c == '0') {
//                     length--;
//                     zeroCnt++;
//                 }
//             }
            
//             StringBuilder sb = new StringBuilder();
//             while (length > 1) {
//                 sb.append((length % 2) + "");
//                 length /= 2;
//             }
//             sb.append("1"); // MSB
            
//             s = sb.reverse().toString();
//             transformCnt++;
//         }
        
//         answer[0] = transformCnt; answer[1] = zeroCnt;
        
//         return answer;
//     }
// }