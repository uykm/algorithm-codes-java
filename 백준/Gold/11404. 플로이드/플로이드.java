import java.util.*;
import java.io.*;

public class Main {
    
    static final int INF = 100000000; 
    static int[][] dist; // 최단 거리 저장 배열
    static int n, m; // 노드 수, 간선 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 최단 거리 배열 초기화
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 간선 정보 입력 및 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // 가중치
            dist[u][v] = Math.min(dist[u][v], w); // 중복 간선 처리
        }

        floydWarshall();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (dist[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j]).append(" ");   
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) { // 중간 노드
            for (int i = 1; i <= n; i++) { // 시작 노드
                for (int j = 1; j <= n; j++) { // 도착 노드
                    if (dist[i][k] != INF && dist[k][j] != INF) { // 경로가 존재하는 경우
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

}