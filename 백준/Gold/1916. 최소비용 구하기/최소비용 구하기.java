import java.util.*;
import java.io.*;

public class Main
{
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int start, end;
    static List<List<City>> roads;
    static int[] dist;
    
    static class City {
        
        int end;
        int weight;
        
        City (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        
    }
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    roads = new ArrayList<>();
	    for (int i = 0; i <= N; ++i) {
	        roads.add(new ArrayList<>());
	    }
	    
	    StringTokenizer st;
	    for (int i = 0; i < M; ++i) {
	        st = new StringTokenizer(br.readLine());
	        int u = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	        int w = Integer.parseInt(st.nextToken());
	        
	        roads.get(u).add(new City(v, w));
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    start = Integer.parseInt(st.nextToken());
	    end = Integer.parseInt(st.nextToken());
	    
	    dist = new int[N + 1];
	    dijkstra();
	    
		System.out.println(dist[end]);
	}
	
	public static void dijkstra() {
	    PriorityQueue<City> pq 
	        = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
	    pq.offer(new City(start, 0));
	    
	    boolean[] visited = new boolean[N + 1];
	    Arrays.fill(dist, INF);
	    dist[start] = 0;
	    
	    while (!pq.isEmpty()) {
	        City cur = pq.poll();
	        int next = cur.end;
	        
	        if (!visited[next]) {
	            visited[next] = true;
	            for (City city : roads.get(next)) {
	                int compare = dist[next] + city.weight;
	                if (!visited[city.end] && dist[city.end] > dist[next] + city.weight) {
	                    dist[city.end] = compare;
	                    pq.offer(new City(city.end, dist[city.end]));
	                }
	            }
	        }
	    }
	}
}
