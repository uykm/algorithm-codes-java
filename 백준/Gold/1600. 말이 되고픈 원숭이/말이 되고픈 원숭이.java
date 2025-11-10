import java.util.*;
import java.io.*;

public class Main {

    static int minMovCnt = -1; // 실패 대비 -1
    static int K, W, H;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dx2 = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy2 = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] map;
    static boolean[][][] visited;

    public static class Monkey {
        int x, y, movCnt, remaininghorseMovCnt;
        public Monkey(int x, int y, int movCnt, int remaininghorseMovCnt) {
            this.x = x;
            this.y = y;
            this.movCnt = movCnt;
            this.remaininghorseMovCnt = remaininghorseMovCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1]; // ★ 0..K까지

        for (int i = 0; i < H; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(minMovCnt);
    }

    public static void bfs() {
        Deque<Monkey> dq = new ArrayDeque<>();
        dq.add(new Monkey(0, 0, 0, K));
        visited[0][0][K] = true;

        while (!dq.isEmpty()) {
            Monkey cur = dq.poll();

            if (cur.x == H - 1 && cur.y == W - 1) {
                minMovCnt = cur.movCnt;
                return;
            }

            // 상하좌우
            for (int d = 0; d < 4; ++d) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (canNotMove(nx, ny, cur.remaininghorseMovCnt)) continue;
                visited[nx][ny][cur.remaininghorseMovCnt] = true;
                dq.add(new Monkey(nx, ny, cur.movCnt + 1, cur.remaininghorseMovCnt));
            }

            // 말(나이트) 이동
            if (cur.remaininghorseMovCnt > 0) {
                for (int d = 0; d < 8; ++d) {
                    int nx = cur.x + dx2[d];
                    int ny = cur.y + dy2[d];
                    int nk = cur.remaininghorseMovCnt - 1;
                    if (canNotMove(nx, ny, nk)) continue;
                    visited[nx][ny][nk] = true;
                    dq.add(new Monkey(nx, ny, cur.movCnt + 1, nk)); // ★ +1 필수
                }
            }
        }
        // 도달 못하면 minMovCnt는 -1 유지
    }

    static boolean canNotMove(int x, int y, int remaininghorseMovCnt) {
        return x < 0 || x >= H || y < 0 || y >= W
                || map[x][y] == 1
                || visited[x][y][remaininghorseMovCnt];
    }
}