class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 가로 길이값을 저장하는 배열에 가로 길이랑 세로 길이 중 더 큰 값을 넣는다
        for(int i = 0; i < sizes.length; ++i) {
            int tmp = 0;
            if (sizes[i][0] < sizes[i][1]) {
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int walletRow = 0;
        int walletCol = 0;
        
        for(int i = 0; i < sizes.length; ++i) {
            // 가로 길이 최대값 탐색 후 저장
            if (sizes[i][0] > walletRow) {
                walletRow = sizes[i][0];
            }
            // 세로 길이 최대값 탐색 후 저장
            if (sizes[i][1] > walletCol) {
                walletCol = sizes[i][1];
            }
        }
        
        return walletRow * walletCol;
    }
}