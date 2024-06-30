class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0, transformCnt = 0;
        
        while (!s.equals("1")) {
            int length = s.length();
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    length--;
                    zeroCnt++;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            while (length > 1) {
                sb.append((length % 2) + "");
                length /= 2;
            }
            sb.append("1"); // MSB
            
            s = sb.reverse().toString();
            transformCnt++;
        }
        
        answer[0] = transformCnt; answer[1] = zeroCnt;
        
        return answer;
    }
}