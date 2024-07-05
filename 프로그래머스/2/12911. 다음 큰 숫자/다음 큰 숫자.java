class Solution {
    public int solution(int n) {
        // int answer = 0;
        // boolean flag = true;
        // int oneCnt = 0;
        // String s = Integer.toBinaryString(n);
        // for (char c : s.toCharArray()) {
        //     if (c == '1') {
        //         oneCnt++;
        //     }
        // }
        // while (flag) {
        //     String tmp = Integer.toBinaryString(++n);
        //     int tmpCnt = 0;
        //     for (char c : tmp.toCharArray()) {
        //         if (c == '1') {
        //             tmpCnt++;
        //         }
        //     }
        //     if (tmpCnt == oneCnt) {
        //         flag = false;
        //         answer = n;
        //     }
        // }
        // return answer;
        
        int a = Integer.bitCount(n);
        while (Integer.bitCount(++n) != a) {}
        return n;
    }
}