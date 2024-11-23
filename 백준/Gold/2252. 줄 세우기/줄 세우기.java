import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static List<List<Integer>> graph;
    static int[] inDegree;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());  // 학생 수
        M = Integer.parseInt(st.nextToken());  // 키 비교 횟수
        inDegree = new int[N + 1]; // 각 노드의 진입 차수를 저장하는 배열
        
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }
        
        List<Integer> sortedOrder;sortedOrder = new ArrayList<>();
        sortedOrder = topologicalSort();
        
        StringBuilder sb = new StringBuilder();
        for (int student : sortedOrder) {
            sb.append(student).append(" ");
        }
        
        System.out.print(sb.toString());
    }
    
    public static List<Integer> topologicalSort() {
        List<Integer> sortedOrder = new ArrayList<>(); // 정렬 결과를 저장할 리스트
        
        // 모든 노드의 진입 차수 계산
        for (int u = 1; u <= N; u++) {
            for (int v : graph.get(u)) {
                inDegree[v]++;
            }
        }
        
        // 진입 차수가 0인 노드를 큐에 추가
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 그래프 처리
        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 노드 제거
            sortedOrder.add(node); // 정렬 결과에 추가
            
            // 현재 노드와 연결된 간선 제거
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--; // 진입 차수를 감소
                if (inDegree[neighbor] == 0) { // 진입 차수가 0이 된 노드를 큐에 추가
                    queue.offer(neighbor);
                }
            }
        }
        
        return sortedOrder; // 위상 정렬 결과 반환
    }
}