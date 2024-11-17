import java.util.*;
import java.io.*;

public class Main {
    
    static final int INF = Integer.MAX_VALUE;
    
    static int V, E, K;
    static int[] distances;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    
    static class Node implements Comparable<Node> {
        int end;
        int distance;
        
        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수
        K = Integer.parseInt(br.readLine()); // 시작 노드
        
        visited = new boolean[V + 1];
        distances = new int[V + 1];
        graph = new ArrayList[V + 1];
        
        for (int i = 1; i <= V; ++i) {
            distances[i] = INF;
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= E; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            
            graph[start].add(new Node(end, distance));
        }
        
        dijkstra();
        
        for (int i = 1; i <= V; ++i) {
            System.out.println(distances[i] == INF ? "INF" : distances[i]);
        }
        
    }
    
    private static void dijkstra() {
        distances[K] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNode = cur.end;
            int curDistance = cur.distance;
            
            // 처음 노드에서 해당 노드까지의 거리가 갱신될 필요없는 경우
            if (curDistance > distances[curNode]) {
                continue;
            }
            
            // 현재 정점과 연결된 모든 정점을 탐색
            for (Node node : graph[curNode]) {
                int newNode = node.end;
                int newDistance = curDistance + node.distance;  // 새로운 거리 계산
                
                // 새로 계산한 거리가 기존 거리보다 작으면 거리 갱신
                if (newDistance < distances[newNode]) {
                    distances[newNode] = newDistance;
                    queue.add(new Node(newNode, newDistance));  // 갱신된 거리를 큐에 추가
                }
            }
        }
    }
    
}