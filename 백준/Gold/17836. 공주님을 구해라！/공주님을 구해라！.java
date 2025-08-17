import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M, T;
    static int[][] castle;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Position sword;
    
    static class Position {
        int x, y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());  // 전역변수에 할당
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        castle = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
                if (castle[i][j] == 2) {
                    sword = new Position(i, j);
                }
            }
        }
        
        int minTime = bfs();
        System.out.println(minTime > T ? "Fail" : minTime);
    }
    
    public static int bfs() {
        boolean[][][] visited = new boolean[N][M][2]; // 검 보유 여부까지 포함
        Queue<int[]> queue = new LinkedList<>(); // {x, y, time, hasSword}
        
        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], time = current[2], hasSword = current[3];
            
            // 도착지 도달
            if (x == N-1 && y == M-1) {
                return time;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int newTime = time + 1;
                int newHasSword = hasSword;
                
                if (!isValid(nx, ny)) continue;
                
                // 검 발견
                if (castle[nx][ny] == 2) {
                    newHasSword = 1;
                }
                
                // 벽인데 검이 없으면 못감
                if (castle[nx][ny] == 1 && newHasSword == 0) continue;
                
                // 이미 방문했으면 스킵
                if (visited[nx][ny][newHasSword]) continue;
                
                visited[nx][ny][newHasSword] = true;
                queue.offer(new int[]{nx, ny, newTime, newHasSword});
            }
        }
        
        return 10001; // 도달 불가
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}