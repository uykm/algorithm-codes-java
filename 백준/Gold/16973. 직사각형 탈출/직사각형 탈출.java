import java.util.*;
import java.io.*;

public class Main {

    static int N, M;         
    static int H, W;         
    static int sr, sc, fr, fc; 
    static int[][] map;      
    static int[][] ps;  // 좌상단에서 특정 좌표까지 벽이 몇 개 있는지 누적한 값
    static int[][] dist;
    static final int INF = -1;

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        ps  = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        H  = Integer.parseInt(st.nextToken());
        W  = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int rowSum = 0;
            for (int j = 1; j <= M; j++) {
                rowSum += map[i][j];
                ps[i][j] = ps[i - 1][j] + rowSum; // (1,1)~(i,j) 영역 내 벽 개수
            }
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        bfs(sr, sc);
        System.out.println(dist[fr][fc]);
    }
    
    static void bfs(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[sx][sy] = 0;
        q.add(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == fr && y == fc) return;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (!isValid(nx, ny)) continue;     // 맵 밖
                if (dist[nx][ny] != INF) continue;  // 이미 방문
                if (!canMove(nx, ny)) continue;     // 벽과 겹침

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
    }

    static boolean isValid(int x, int y) {
        if (x < 1 || y < 1) return false;
        if (x + H - 1 > N) return false;
        if (y + W - 1 > M) return false;
        return true;
    }

    static boolean canMove(int x, int y) {
        int x2 = x + H - 1;
        int y2 = y + W - 1;
        int sum = ps[x2][y2] - ps[x - 1][y2] - ps[x2][y - 1] + ps[x - 1][y - 1];
        return sum == 0;
    }
    
}