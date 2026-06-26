class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // 0 = 원래 죽음, 다음에도 죽음
        // 1 = 원래 생존, 다음에도 생존
        // 2 = 원래 생존, 다음에는 죽음
        // 3 = 원래 죽음, 다음에는 생존
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // 지금은 살아있는 이웃 카운트
                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }

                    // 지금은 살아있는 이웃
                    if (board[nx][ny] == 1 || board[nx][ny] == 2) {
                        liveNeighbors++;
                    }
                }

                // 지금은 살아있음
                if (board[i][j] == 1) {
                    // 살아있는 이웃이 2개 미만 또는 3개 초과면 죽음
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; 
                    }
                } 
                else { // board[i][j] == 0
                    // 죽어있지만, 살아있는 이웃이 정확히 3개면 살아남
                    if (liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        // 살아났거나 죽은 세포들 탐색해서 업데이트
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) { //
                    board[i][j] = 1;
                }
            }
        }
    }
}