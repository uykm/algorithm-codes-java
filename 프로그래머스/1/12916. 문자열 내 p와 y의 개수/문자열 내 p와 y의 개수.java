class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp == 'p' || tmp == 'P') {
                pCnt++;
            } else if(tmp == 'y' || tmp == 'Y') {
                yCnt++;
            }
        }

        return pCnt == yCnt ? true : false;
    }
}