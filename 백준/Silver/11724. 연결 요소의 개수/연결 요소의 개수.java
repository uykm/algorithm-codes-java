import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] arr = new ArrayList[N + 1];
        boolean[] check = new boolean[N + 1];
        
        for (int i = 0; i <= N; ++i) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            arr[node1].add(node2);
            arr[node2].add(node1);
        }
        
        int count = 0;
        for (int i = 1; i <= N; ++i) {
            if (check[i] == true) continue;
            
            bfs(i, arr, check);
            count++;
        }
        
        System.out.print(count);
    }
    
    public static void bfs(int node, List<Integer>[] arr, boolean[] check) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(node); // 시작 노드 추가
        check[node] = true;
        
        while (!queue.isEmpty()) {
            
            int num1 = queue.remove();
            
            for (int i = 0; i < arr[num1].size(); ++i) {
                
                int num2 = arr[num1].get(i);
                
                if (!check[num2]) { // bfs인 이유 -> 방문하지 않은 노드이면 지속 탐색
                    queue.add(num2);
                    check[num2] = true;
                }
            }
        }
    }
}