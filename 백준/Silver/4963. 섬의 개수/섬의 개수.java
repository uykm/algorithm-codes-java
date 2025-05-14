import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] island;
    static int[][] visited;
    static int w, h; // 가로, 세로

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 1 = 땅 , 0 = 바다
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) { // 입력값이 0 0
                break;
            }

            island = new int[h][w];
            visited = new int[h][w];
            int ans = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] != 1 && island[i][j] == 1) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }

    }

    static void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (island[nx][ny] == 1 && visited[nx][ny] != 1)
                dfs(nx, ny);
        }

    }
}