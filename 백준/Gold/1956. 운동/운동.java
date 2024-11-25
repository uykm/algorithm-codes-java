import java.util.*;
import java.io.*;

public class Main {
    
    static final int INF = 100000000;
    static int[][] dist;
    static int V, E;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        // 최단 거리 배열 초기화
        dist = new int[V + 1][V + 1];
        for (int i = 1; i <= V; ++i) {
            Arrays.fill(dist[i], INF);
            // dist[i][i] = 0; // 이 문제에선 자기 자신으로 가는 비용이 0이 아닐 수 있다.
        }
        
        // 간선 정보 입력 및 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[u][v] = Math.min(dist[u][v], w); // 중복 간선 처리
        }
        
        floydWarshall();
        
        // 최소 사이클 찾기
        int minCycle = INF;
        for (int i = 1; i <= V; i++) {
            if (dist[i][i] < minCycle) {
                minCycle = dist[i][i];
            }
        }

        // 결과 출력
        if (minCycle == INF) {
            System.out.print("-1");
        } else {
            System.out.print(minCycle);
        }
    }
    
    public static void floydWarshall() {
        for (int k = 1; k <= V; ++k) {
            for (int i = 1; i <= V; ++i) {
                for (int j = 1; j <= V; ++j) {
                    if (dist[i][k] != INF && dist[k][j] != INF) { // 중간 경로가 존재하는 경우
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}