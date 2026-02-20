import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int R, C;
    static int airTop, airBottom;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    int time = Integer.parseInt(st.nextToken());
	    
	    board = new int[R][C];
	    
	    for (int i = 0; i < R; ++i) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < C; ++j) {
	            int num = Integer.parseInt(st.nextToken());
	            board[i][j] = num;
	            
	        }
	    }
	    
	    for (int i = 0; i < R; ++i) {
	        if (board[i][0] == -1) {
	           airTop = i; 
               airBottom = i+1;
               break;
	        }
	    }
	    
	    while (time-- > 0) {
	        board = spreadDust();
	        purifyAir();
	    }
	    
		int total = 0;
		for (int[] row : board) {
		    for (int c : row) {
		        if (c > 0) total += c;
		    }
		}
		
		System.out.print(total);
	}
	
	static int[][] spreadDust() {
	    int[][] tmp = new int[R][C];
	    for (int i = 0; i < R; ++i) {
	        for (int j = 0; j < C; ++j) {
	            if (board[i][j] == -1) {
	                tmp[i][j] = -1;
	                continue;
	            }
	            tmp[i][j] += board[i][j];
	            
	            int spread = board[i][j] / 5;
	            for (int k = 0; k < 4; ++k) {
	                int nx = i + dx[k], ny = j + dy[k];
	                
	                if (nx < 0 || nx >= R || ny < 0 || ny >= C 
	                    || board[nx][ny] == -1) continue;
	                
	                tmp[nx][ny] += spread;
	                tmp[i][j] -= spread;
	            }
	        }
	    }
	    return tmp;
	}
	
	static void purifyAir() {
	    // 위쪽 순환
	    for (int row = airTop-1; row > 0; --row) // 왼편
	        board[row][0] = board[row-1][0];
	        
	    for (int col = 0; col < C-1; ++col) // 위편
	        board[0][col] = board[0][col+1];
	        
	    for (int row = 0; row < airTop; ++row) 
	        board[row][C-1] = board[row+1][C-1]; // 오른편
	        
	    for (int col = C-1; col > 1; --col) 
	        board[airTop][col] = board[airTop][col-1]; // 아래편
	    
	    // 아래쪽 순환
	    for (int row = airBottom+1; row < R-1; ++row) // 왼편
	        board[row][0] = board[row+1][0];
	   
	    for (int col = 0; col < C-1; ++col) // 아래편
	        board[R-1][col] = board[R-1][col+1];
	   
	    for (int row = R-1; row > airBottom; row--) // 오른편 
	        board[row][C-1] = board[row-1][C-1];
	        
	    for (int col = C-1; col > 1; --col) // 아래편
	        board[airBottom][col] = board[airBottom][col-1];
	    
	    // 공기 청정기에서 나간 바람 정화
	    board[airTop][1] = 0;
	    board[airBottom][1] = 0;
	}
}
