import java.util.*;
import java.io.*;

public class Main {
    
    static int ROW, COL;
    static int[][] iceberg;
    static int year;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
	public static void main(String[] args) throws IOException {
	    
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine());
	    
	    ROW = Integer.parseInt(st.nextToken());
	    COL = Integer.parseInt(st.nextToken());
	    
	    iceberg = new int[ROW][COL];
	    
	    for (int i = 0; i < ROW; ++i) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < COL; ++j) {
	            iceberg[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    int years = 0;
	    
	    while (true) {
	        int count = 0;
            visited = new boolean[ROW][COL];

            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (iceberg[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }
            if (count > 1) {
                System.out.println(years);
                return;
            }

            simulateMelting();
            years++;
	    }
	   
	}
	
	static void simulateMelting() {
	    int[][] newIceberg = new int[ROW][COL];

	    for (int i = 0; i < ROW; ++i) {
	       for (int j = 0; j < COL; ++j) {
	            if (iceberg[i][j] == 0) continue;
	            int meltingCnt = 0;
	                
	            for (int k = 0; k < 4; ++k) {
                    int nx = i + dx[k];
	                int ny = j + dy[k];
	                    
                    if (0 <= nx && nx < ROW && 0 <= ny && ny < COL
                                && iceberg[nx][ny] == 0) 
                    meltingCnt++;
                }
	                
	            newIceberg[i][j] = iceberg[i][j] - meltingCnt;
                if (newIceberg[i][j] < 0) newIceberg[i][j] = 0;
            }
	    }
	    
	    iceberg = newIceberg;
	}
	
	static void bfs(int x, int y) {
	    Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                
                if (0 <= nx && nx < ROW && 0 <= ny && ny < COL) {
                    if (!visited[nx][ny] && iceberg[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
	    
	}
}