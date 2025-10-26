import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int V, M, E;
    static int[] items;
    static List<Node>[] graph;

    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) { this.v = v; this.w = w; }
        public int compareTo(Node o) { return Integer.compare(this.w, o.w); }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        items = new int[V + 1];
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= V; i++) items[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        int answer = 0;
        for (int start = 1; start <= V; start++) {
            int[] dist = dijkstra(start);
            int sum = 0;
            for (int i = 1; i <= V; i++) {
                if (dist[i] <= M) {
                    sum += items[i];
                }
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;
            
            for (Node nb : graph[cur.v]) {
                int nd = cur.w + nb.w;
                if (nd < dist[nb.v]) {
                    dist[nb.v] = nd;
                    pq.offer(new Node(nb.v, nd));
                }
            }
        }
        return dist;
    }
}