class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int totalOutlineCount = n / 2;

        for (int outline = 0; outline < totalOutlineCount; ++outline) {
            int first = outline;
            int last = n - 1 - outline;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }
    }
}