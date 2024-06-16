class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int max = n;
        boolean[] lostCheck = new boolean[n];
        boolean[] reserveCheck = new boolean[n];
        
        for (int lst : lost) {
            lostCheck[lst-1] = true;
        }
        
        for (int rsv : reserve) {
            reserveCheck[rsv-1] = true;
        }
        
        // 도난 당한 사람들 중 본인에게 여벌이 있는 경우 체크
        for (int i = 0; i < n; ++i) {
            if (reserveCheck[i] && lostCheck[i]) {
                lostCheck[i] = false;
                reserveCheck[i] = false;
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (lostCheck[i]) {
                if ((i > 0) && reserveCheck[i-1]) {
                    lostCheck[i] = false;
                    reserveCheck[i-1] = false;
                } else if ((i < n-1) && reserveCheck[i+1]) {
                    lostCheck[i] = false;
                    reserveCheck[i+1] = false;
                }
            }
        }
        
        for (boolean lc : lostCheck) {
            if (lc) max--;
        }
        
        return max;
    }
}