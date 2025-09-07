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

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(start, end, weight));
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
        int start, end, weight;
        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void bellmanFord() {
        // 최단 거리 배열 초기화
        dist = new long[V + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 모든 간선 검사를 V-1번 반복해서 거리 갱신
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edgeList) {
                if (dist[edge.start] != INF &&
                        dist[edge.start] + edge.weight < dist[edge.end]) {
                    dist[edge.end] = dist[edge.start] + edge.weight;
                }
            }
        }

        // 모든 간선을 한 번 더 검사해서 거리가 갱신되는 경우가 있으면 음수 사이클 존재
        for (Edge edge : edgeList) {
            if (dist[edge.start] != INF &&
                    dist[edge.start] + edge.weight < dist[edge.end]) {
                isMinusCycle = true;
                return;
            }
        }
    }
}