class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int arrowsCnt = 0;
        int start = points[0][0];
        int end = points[0][1];

        for (int i = 1; i < points.length; ++i) {
            // 이어지지 X
            if (points[i][0] > end) {
                arrowsCnt++;
                start = points[i][0];
                end = points[i][1];
            }
            // 출발점 갱신
            else if (points[i][1] > end) {
                start = points[i][0];
            }
            // 범위 좁히기
            else {
                start = points[i][0];
                end = points[i][1];
            }
        }

        arrowsCnt++;

        return arrowsCnt;
    }
}