class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 첫 번쨰 행과 첫 번쨰 열을 마커로 활용하기 위해, 첫 번째 행과 열에 0이 있었는지는 따로 체크 필요
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < row; ++i) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            } 
        }

        for (int i = 0; i < col; ++i) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            } 
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int i = 0; i < col; ++i) {
                matrix[0][i] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < row; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}