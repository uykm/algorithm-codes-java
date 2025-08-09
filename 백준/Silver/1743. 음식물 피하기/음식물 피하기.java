import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static int[][] graph;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		int r, c;
		for (int i = 0; i < K; ++i) {
		    st = new StringTokenizer(br.readLine());
		    r = Integer.parseInt(st.nextToken());
		    c = Integer.parseInt(st.nextToken());
		    graph[r-1][c-1] = 1;
		}
		
		int maxSize = 0;
		
		
		for (int i = 0; i < N; ++i) {
		    for (int j = 0; j < M; ++j) {
		        if (graph[i][j] == 1 && !visited[i][j]) {
		            int currentSize = dfs(i, j);
		            maxSize = Math.max(maxSize, currentSize);
		        }
		    }
		}
		
		System.out.println(maxSize);
		
	}
	
	private static int dfs(int x, int y) {
	    
	    visited[x][y] = true;
	    int size = 1;
	    
	    for (int i = 0; i < 4; ++i) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        
	        if (isValid(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 1) {
	            size += dfs(nx, ny);
	        }
	    }
	    
	    return size;
	}
	
	private static boolean isValid(int x, int y) {
	    return x >= 0 && x < N && y >= 0 && y < M;
	}
}
