import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static List<Edge> edgeList;
    static long[] dist;
    static boolean isMinusCycle;
    static int V, E;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();

        // 간선 정보 입력 및 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(src, dest, weight));
        }

        // 벨만포드 실행
        bellmanFord();

        // 음수 사이클이 있는 경우 바로 종료
        if (isMinusCycle) {
            System.out.println("-1");
        } else {
            // 최단 거리 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= V; i++) {
                sb.append(dist[i] == INF ? "-1" : dist[i]).append("\n");
            }
            System.out.print(sb.toString());
        }

        br.close();
    }

    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void bellmanFord() {
        // 최단 거리 배열 초기화
        dist = new long[V + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // (V-1)번 간선 완화 반복
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edgeList) {
                if (dist[edge.src] != INF &&
                        dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }

        // 음수 사이클 확인
        for (Edge edge : edgeList) {
            if (dist[edge.src] != INF &&
                    dist[edge.src] + edge.weight < dist[edge.dest]) {
                isMinusCycle = true;
                return;
            }
        }
    }
}