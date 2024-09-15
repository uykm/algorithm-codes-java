class Solution {
    public long solution(int n) {
        // 첫 두 값 초기화
        long fb1 = 1;
        long fb2 = 2;
        
        // n이 1이나 2일 경우 미리 반환
        if (n == 1) {
            return fb1;
        } else if (n == 2) {
            return fb2;
        }

        // 세 번째 값부터 계산
        long result = 0;
        for (int i = 3; i <= n; i++) {
            result = (fb1 + fb2) % 1234567;
            fb1 = fb2; // 이전 두 값을 갱신
            fb2 = result;
        }

        return result;
    }
}