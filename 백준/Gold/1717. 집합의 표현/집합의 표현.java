import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static int[] parent;  // 부모 노드 저장
    static int[] rank;    // 각 노드의 랭크(트리 높이)
    
    static void makeSet(int size) {
        parent = new int[size];
        rank = new int[size];
        
        for (int i = 0; i < size; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);  // 경로 압축
        }
        return parent[node];
    }
    
    static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        
        if (root1 != root2) {
            // 랭크를 기준으로 union
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }
    
    static boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());  // 집합의 개수: n + 1
        m = Integer.parseInt(st.nextToken());  // 연산의 개수
        
        makeSet(n + 1);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            
            int input = Integer.parseInt(st.nextToken());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            if (input == 1) {
                sb.append(isConnected(node1, node2) ? "YES" : "NO");
                sb.append("\n");
            } else if (input == 0) {
                union(node1, node2);
            }
        }
        
        System.out.print(sb.toString());
    }
}