import java.util.*;
import java.io.*;

public class Main {
    
    static int row;
    static int col;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        graph = new int[row][col];
        visited = new boolean[row][col];
        
        for (int i = 0; i < row; ++i) {
            String line = br.readLine();  // 한 줄씩 입력 받음
            for (int j = 0; j < col; ++j) {
                graph[i][j] = line.charAt(j) - '0';  // 한 글자씩 처리하여 숫자로 변환
            }
        }
        
        visited[0][0] = true; //출발지
        bfs(0, 0);
        
        System.out.println(graph[row-1][col-1]);
    }
    
     public static void bfs(int x, int y) {
         
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];

            for(int i=0;i<4;i++) {
                
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if((nextX >= 0) && (nextX < row) && (nextY >= 0) && (nextY < col)) {
                    if(graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        
                        q.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        graph[nextX][nextY] = graph[nx][ny] + 1;
                    }
                }
            }
        }
     }
}