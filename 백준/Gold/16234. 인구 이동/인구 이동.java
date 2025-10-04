import java.util.*;
import java.io.*;

public class Main {
    
    static int N, L, R;
    static int[][] arr;
    static List<int[]> linkedCountries;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    arr = new int[N][N];
	    
	    for (int i = 0; i < arr.length; ++i) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < arr[0].length; ++j) {
	            arr[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    int moveCnt = 0;
	    while (true) {
	        boolean doMove = false;
	        visited = new boolean[N][N];
	        for (int i = 0; i < N; ++i) {
	            for (int j = 0; j < N; ++j) {
	                if (!visited[i][j]) {
	                    int sum = dfs(i, j);
	                    if (linkedCountries.size() > 1) {
	                        int avg = sum / linkedCountries.size();
	                        equalizeToAvg(avg);
	                        doMove = true;
	                    }
	                }
	            }
	        }
	        if (!doMove) break;
	        moveCnt++;
	    }
		
		System.out.print(moveCnt);
	}
	
	public static void equalizeToAvg(int avg) {
	    for (int i = 0; i < linkedCountries.size(); ++i) {
	        int x = linkedCountries.get(i)[0];
	        int y = linkedCountries.get(i)[1];
	        arr[x][y] = avg;
	    }
	}
	
	
	public static int dfs(int x, int y) {
	    Queue<int[]> queue = new LinkedList<>();
	    queue.offer(new int[]{x, y});
	    
	    linkedCountries = new ArrayList<>();
	    linkedCountries.add(new int[]{x, y});
	    
	    visited[x][y] = true;
	    int sum = arr[x][y];
	    
	    while (!queue.isEmpty()) {
	        int[] current = queue.poll();
	        int cx = current[0], cy = current[1];
	        
	        for (int i = 0; i < 4; ++i) {
	            int nx = current[0] + dx[i];
	            int ny = current[1] + dy[i];
	            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
	                int diff = Math.abs(arr[nx][ny] - arr[cx][cy]);
	                if (!visited[nx][ny] && L <= diff && diff <= R) {
	                    visited[nx][ny] = true;
	                    queue.offer(new int[]{nx, ny});
	                    linkedCountries.add(new int[]{nx, ny});
	                    sum += arr[nx][ny];
	                }
	            }
	        }
	    }
	    
	    return sum;
	}
	
}
