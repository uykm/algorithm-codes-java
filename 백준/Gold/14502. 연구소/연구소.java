import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int answer = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        findMaxSafeZone(0);    
        
        System.out.println(answer);
    }
    
    static void findMaxSafeZone(int wallCnt) {
        if (wallCnt == 3) {
            confirmSafeZone();
            return;
        }
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    findMaxSafeZone(wallCnt + 1);
                    board[i][j] = 0;
                }
            }
        }
    }
    
    static void confirmSafeZone() { // bfs
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] copiedBoard = new int[N][M];
        for (int i = 0; i < N; ++i) {
            copiedBoard[i] = board[i].clone();
        }
        
        spreadVirus(queue, copiedBoard);
        
        countSafeZone(copiedBoard);
    }
    
    static void spreadVirus(ArrayDeque<int[]> queue, int[][] copiedBoard) { // 
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M
                        && copiedBoard[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    copiedBoard[nx][ny] = 2;
                }
            }
        }
    }
    
    static void countSafeZone(int[][] copiedBoard) {
        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (copiedBoard[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(count, answer);
    }
    
}