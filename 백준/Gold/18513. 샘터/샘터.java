import java.util.*;
import java.io.*;

public class Main{
    
    static int lake;  // 샘터의 개수
    static int house;  // 지어야하는 집의 개수
    static Queue<Integer> queue;
    static Set<Integer> visited;
    
	public static void main(String[] args) throws IOException {
	    
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine());
	    
	    lake = Integer.parseInt(st.nextToken());
	    house = Integer.parseInt(st.nextToken());
	    
	    queue = new LinkedList<>();
	    visited = new HashSet<Integer>();
	    
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < lake; ++i) {
	        int lakePos = Integer.parseInt(st.nextToken());
	        queue.add(lakePos);
	        visited.add(lakePos);
	    }
	    
	    long min = bfs();
	    
	    System.out.print(min);
	}
	
	public static long bfs() {
	    long totalMisfortune = 0;
	    int dist = 1;
	    int[] dir = {-1, 1};
	    
	    while (!queue.isEmpty()) {
	        int houseCntInSameDist = queue.size();
	        
	        for (int i = 0; i < houseCntInSameDist; ++i) {
	            int pos = queue.poll();
	            
	            // queue에서 뽑아낸 좌표를 기준으로 왼쪽 or 오른쪽에 집을 짓는 경우
	            for (int j = 0; j < 2; ++j) {
    	            int npos = pos + dir[j];
    	            
    	            if (!visited.contains(npos)) {
    	                queue.add(npos);
    	                visited.add(npos);
    	                house--;
    	                totalMisfortune += dist;
    	                
    	                if (house == 0) 
    	                    return totalMisfortune;
    	            }
    	        }
	        }
	        dist++;
	    }
	    
	    return totalMisfortune;
	}
}
