class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int max = n;
        boolean[] lostCheck = new boolean[n];
        boolean[] reserveCheck = new boolean[n];
        
        // 도난 당한 사람 체크
        for (int lst : lost) {
            lostCheck[lst-1] = true;
        }
        
        // 여벌 있는 사람 체크
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
        
        // 도난 당한 사람들 중 본인에게 여벌이 없고, 빌릴 수 있는 경우 체크
        for (int i = 0; i < n; ++i) {
            if (lostCheck[i]) {
                // 앞 사람에게 여벌이 있는 경우
                if ((i > 0) && reserveCheck[i-1]) {
                    lostCheck[i] = false;
                    reserveCheck[i-1] = false;
                } 
                // 뒷 사람에게 여벌이 있는 경우
                else if ((i < n-1) && reserveCheck[i+1]) {
                    lostCheck[i] = false;
                    reserveCheck[i+1] = false;
                }
            }
        }
        
        // 빌리지 못한 경우 체크
        for (boolean lc : lostCheck) {
            if (lc) max--;
        }
        
        return max;
    }
}