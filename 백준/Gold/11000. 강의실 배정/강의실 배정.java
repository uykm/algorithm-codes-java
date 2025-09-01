import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[][] schedules;
    
	public static void main(String[] args) throws IOException {
	    
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    schedules = new int[N][2];
	    
	    for (int i = 0; i < N; ++i) {
	        st = new StringTokenizer(br.readLine());
	        schedules[i][0] = Integer.parseInt(st.nextToken());
	        schedules[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(schedules, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
	    
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for (int i = 0; i < N; ++i) {
	        int start = schedules[i][0];
	        int end = schedules[i][1];
	        
	        if (!pq.isEmpty() && pq.peek() <= start) {
	            pq.poll();
	        }
	        
	        pq.offer(end);
	    }
	    
	    System.out.println(pq.size());
	}
}