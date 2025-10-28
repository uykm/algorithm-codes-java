import java.util.*;
import java.io.*;

public class Main {
    static int[] parent, rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 총 도시 수
        int M = Integer.parseInt(br.readLine()); // 여행 시 방문하는 도시 수
        
        parent = new int[N+1];
        rank = new int[N+1];
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; ++j) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] travelRoute = new int[M];
        boolean flag = true;
        int start = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i < M; ++i) {
            int city = Integer.parseInt(st.nextToken());
            if (find(city) == find(start)) {
                continue;
            }
            flag = false;
            break;
        }
        
        if (flag == true) System.out.println("YES");
        else System.out.println("NO");
    }
    
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }

}