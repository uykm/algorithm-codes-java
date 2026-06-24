class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowDuplicated = new boolean[9][10];
        boolean[][] colDuplicated = new boolean[9][10];
        boolean[][] boxDuplicated = new boolean[9][10];

        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                char num = board[r][c];
                if(num == '.') {
                    continue;
                }

                int value = num - '0';
                int boxNum = r/3 * 3 + c/3;
                if (rowDuplicated[r][value] || colDuplicated[c][value] 
                    || boxDuplicated[boxNum][value]) {
                    return false;
                }

                rowDuplicated[r][value] = true;
                colDuplicated[c][value] = true;
                boxDuplicated[boxNum][value] = true;
            }
        }

        return true;
    }
}