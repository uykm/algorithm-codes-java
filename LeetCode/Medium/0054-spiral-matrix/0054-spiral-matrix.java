class Solution {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];

        int curX = 0;
        int curY = 0;
        int dir = 0;
        int count = 0;
        int total = row * col;
        List<Integer> answer = new ArrayList<>();

        while (count < total) {
            answer.add(matrix[curX][curY]);
            visited[curX][curY] = true;
            count++;

            int nx = curX + dx[dir % 4];
            int ny = curY + dy[dir % 4];
            if (nx < 0 || nx > (row-1) || ny < 0 || ny > (col-1)
                    || visited[nx][ny]) {
                dir++;
                nx = curX + dx[dir % 4];
                ny = curY + dy[dir % 4];
            }

            curX = nx;
            curY = ny;
        }

        return answer;
    }
}