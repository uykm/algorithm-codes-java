import java.util.*;
import java.io.*;

public class Main {
    
    static int M, N, K;
    static char[][] map;
    static int[][] jSum, oSum, iSum;
    
	public static void main(String[] args) throws IOException {
	    
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine());
	    
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(br.readLine());
	    
	    map = new char[M+1][N+1];
	    jSum = new int[M+1][N+1];
	    oSum = new int[M+1][N+1];
	    iSum = new int[M+1][N+1];
	    
	    for (int i = 1; i <= M; ++i) {
	        String input = br.readLine();
	        
	        for (int j = 1; j <= N; ++j) {
	            map[i][j] = input.charAt(j-1);
	            jSum[i][j] = jSum[i-1][j] + jSum[i][j-1] - jSum[i-1][j-1];
	            oSum[i][j] = oSum[i-1][j] + oSum[i][j-1] - oSum[i-1][j-1];
	            iSum[i][j] = iSum[i-1][j] + iSum[i][j-1] - iSum[i-1][j-1];
	            
	            if (map[i][j] == 'J')  jSum[i][j]++;
	            else if (map[i][j] == 'O') oSum[i][j]++;
	            else iSum[i][j]++;
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < K; ++i) {
	        st = new StringTokenizer(br.readLine());
	        int sr = Integer.parseInt(st.nextToken());  // 시작 행 번호 
	        int sc = Integer.parseInt(st.nextToken());  // 시작 열 번호
	        int er = Integer.parseInt(st.nextToken());  // 끝 행 번호
	        int ec = Integer.parseInt(st.nextToken());  // 끝 열 번호
	        
	        int jCnt = jSum[er][ec] - jSum[sr-1][ec] - jSum[er][sc-1] + jSum[sr-1][sc-1];
            int oCnt = oSum[er][ec] - oSum[sr-1][ec] - oSum[er][sc-1] + oSum[sr-1][sc-1];
            int iCnt = iSum[er][ec] - iSum[sr-1][ec] - iSum[er][sc-1] + iSum[sr-1][sc-1];
	        
	        sb.append(jCnt).append(' ').append(oCnt).append(' ').append(iCnt).append('\n');
	    }
	    
	    System.out.print(sb);
	}
}