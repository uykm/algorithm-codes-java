import java.util.*;
import java.io.*;

public class Main {
    
    static final int LEFT_SET = -1;
    static final int RIGHT_SET = 1;
    static List<List<Integer>> graph;  // ex: 1 -> 2, 3
    static boolean[] visited;
    static int[] vertexSet;  // index: 정점 / value: 해당 정점이 속해있는 집합
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (testCaseCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertexCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            visited = new boolean[vertexCount + 1];
            
            graph = new ArrayList<>();
            for (int i = 0; i <= vertexCount; i++) {  // 정점이 1번부터 시작하기 때문에 !
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
            
            if (isBipartite(vertexCount)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    public static boolean isBipartite(int vertexCount) {
        vertexSet = new int[vertexCount + 1];  // 0: 미설정, 1: LEFT_SET, 2: RIGHT_SET

        for (int i = 1; i <= vertexCount; ++i) {
            if (!visited[i] && !bfsCheck(i)) {  // 아직 방문하지 않은 정점만 탐색
                return false;
            }
        }
        return true;
    }
    
    public static boolean bfsCheck(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;  // 시작 정점을 방문 표시
        vertexSet[start] = LEFT_SET;
        
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 노드
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    // 이웃 노드가 아직 방문하지 않은 경우
                    visited[neighbor] = true;  // 방문 표시
                    vertexSet[neighbor] = -vertexSet[current];  // 반대 집합으로 설정
                    queue.add(neighbor);
                } else if (vertexSet[neighbor] == vertexSet[current]) {
                    // 이웃 노드가 같은 집합에 있는 경우
                    return false;
                }
            }
        }
        return true;
    }
}