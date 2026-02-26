import java.util.*;
import java.io.*;
    
public class Main {
    
    static final int INF = Integer.MAX_VALUE;
    static int N, X;
    static List<List<Town>> roads, reverseRoads;
    
    static class Town {
        int end;
        int weight;
        
        Town(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		roads = new ArrayList<>(); // 문제의 입력을 그대로 받은 배열
        reverseRoads = new ArrayList<>(); // 문제의 입력을 반대로 받은 배열
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
            reverseRoads.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            roads.get(start).add(new Town(end, weight));
            reverseRoads.get(end).add(new Town(start, weight));
        }
		
		int[] dist = dijkstra(roads); // n -> X
		int[] reverseDist = dijkstra(reverseRoads); // X -> n
		
		int longestMinTime = 0;
		for (int i = 1; i <= N; ++i) {
		    longestMinTime = Math.max(longestMinTime, dist[i] + reverseDist[i]);
		}
		
		System.out.print(longestMinTime);
	}
	
	public static int[] dijkstra(List<List<Town>> roads) {
	    PriorityQueue<Town> pq = 
	        new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
	    pq.offer(new Town(X, 0));
	    
	    boolean[] visited = new boolean[N+1];
	    int[] dist = new int[N + 1];
	    Arrays.fill(dist, INF);
	    dist[X] = 0;
	    
	    while (!pq.isEmpty()) {
	        Town cur = pq.poll();
	        int next = cur.end;
	        
	        if (!visited[next]) {
	            visited[next] = true;
	            for (Town town : roads.get(next)) {
	                // next -> town.end 간선 갱신
    	            if (!visited[town.end] && dist[town.end] > dist[next] + town.weight) {
    	                dist[town.end] = dist[next] + town.weight;
    	                pq.offer(new Town(town.end, dist[town.end]));
    	            }
    	        }   
	        }
	    }
	    
	    return dist;
	}
}
