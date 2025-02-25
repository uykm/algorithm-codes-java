import java.util.*;
import java.io.*;

public class Main {
    static int SPOT; // 지점 수
    static int ROAD; // 도로 수
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static List<Integer> path;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        SPOT = Integer.parseInt(st.nextToken());
        ROAD = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[SPOT + 1];  // 1-based index 사용
        for (int i = 1; i <= SPOT; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < ROAD; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            
            graph[start].add(new Node(end, dist)); // 양방향 그래프
            graph[end].add(new Node(start, dist));
        }
        
        int blockedPath = findMinPath(1, SPOT);
        int awayPath = findNonBlockedMaxPath(1, SPOT, blockedPath);
        
        if (awayPath == -1) { 
            System.out.println("-1"); // 최단 경로가 존재하지 않음
        } else {
            int delay = awayPath - blockedPath;
            System.out.println(delay);
        }
    }

    static class Node implements Comparable<Node> {
        int end, cost;
        
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public static void removeEdge(int u, int v) {
        graph[u].removeIf(node -> node.end == v);
    }

    public static void restoreEdge(int u, int v, int dist) {
        if (graph[u] != null) {
            graph[u].add(new Node(v, dist));
        }
    }
    
    public static int findMinPath(int start, int end) {
        dist = new int[SPOT + 1];  // 1-based index 사용
        int[] prev = new int[SPOT + 1]; // 이전 노드 저장 배열
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        
        dist[start] = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNode = cur.end;
            int curDist = cur.cost;
            
            if (curDist > dist[curNode]) continue;
            
            for (Node node : graph[curNode]) {
                int newNode = node.end;
                int newDist = curDist + node.cost;
                
                if (newDist < dist[newNode]) {
                    dist[newNode] = newDist;
                    prev[newNode] = curNode;
                    queue.add(new Node(newNode, newDist));
                }
            }
        }
        
        if (path == null) {
            path = new ArrayList<>();
            for (int at = end; at != -1; at = prev[at]) {
                path.add(at);
            }
            
            Collections.reverse(path);
        }
        
        Collections.reverse(path);
        
        return dist[end];
    }

    public static int findNonBlockedMaxPath(int start, int end, int blockedDist) {
        int newDist = -1;

        for (int i = 0; i < path.size() - 1; i++) {
            int u = path.get(i);
            int v = path.get(i + 1);
            
            // 복원하기 위한 간선 가중치값
            int originalDist = -1;
            for (Node neighbor : graph[u]) {
                if (neighbor.end == v) {
                    originalDist = neighbor.cost;
                    break;
                }
            }

            removeEdge(u, v);
            removeEdge(v, u);
            int tempDist = findMinPath(start, end);
            restoreEdge(u, v, originalDist); // 간선 복원
            restoreEdge(v, u, originalDist); // 간선 복원

            if (tempDist > newDist) {
                newDist = tempDist;
            }
        }

        return newDist == INF ? -1 : newDist;
    }
}