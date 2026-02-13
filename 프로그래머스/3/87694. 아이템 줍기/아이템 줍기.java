import java.util.*;

class Solution {
    
    static final int MAX = 102; // 좌표가 1~50이면 *2 해서 100, 여유로 102
    static boolean[][] filled = new boolean[MAX][MAX]; // 사각형 영역(내부+테두리) 전체
    static boolean[][] boarder  = new boolean[MAX][MAX]; // 최종 "길"(테두리)만 true
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        buildBorderBoard(rectangle);
        return bfs(characterX, characterY, itemX, itemY);
    }
    
    static void buildBorderBoard(int[][] rectangles) {
        for (int[] r : rectangles) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            
            for (int y = y1; y <= y2; ++y) {
                for (int x = x1; x <= x2; ++x) {
                    filled[y][x] = true;
                }
            }
        }
        
        for (int y = 0; y < MAX; ++y) {
            for (int x = 0; x < MAX; ++x) {
                if (filled[y][x]) boarder[y][x] = true;
            }
        }
        
        for (int[] r : rectangles) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            
            for (int y = y1 + 1; y <= y2 - 1; ++y) {
                for (int x = x1 + 1; x <= x2 - 1; ++x) {
                    boarder[y][x] = false;
                }
            }
        }
    }
    
    static int bfs(int sx, int sy, int tx, int ty) {
        sx *= 2; sy *= 2;
        tx *= 2; ty *= 2;
        
        int[][] dist = new int[MAX][MAX];
        for (int i = 0; i < MAX; ++i) Arrays.fill(dist[i], -1);
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        dist[sy][sx] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            if (x == tx && y == ty) return dist[y][x] / 2;
            
            for (int k = 0; k < 4; ++k) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if (!boarder[ny][nx]) continue;
                if (dist[ny][nx] != -1) continue;
                
                dist[ny][nx] = dist[y][x] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        return -1;
    }
}