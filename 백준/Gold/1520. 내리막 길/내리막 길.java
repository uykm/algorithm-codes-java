import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int M, N;
    static int[][] dp;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N]; // dp[i][j]: (i, j)에서 (M-1, N-1)까지 갈 수 있는 경로의 수

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 방문하지 않은 곳은 -1
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == M-1 && y == N-1) {
            return 1; // 도착 지점에 도달
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (dp[x][y] == -1) {
            dp[x][y] = 0; // 방문 체크
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue; // 범위를 벗어나는 경우
                }

                if (map[nx][ny] < map[x][y]) { // 현재 위치보다 낮은 곳으로만 이동
                    dp[x][y] += dfs(nx, ny); // 다음 위치로 이동하여 경로 수 계산
                }
            }
        }

        return dp[x][y];
    }

}