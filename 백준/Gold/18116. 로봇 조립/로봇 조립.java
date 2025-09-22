import java.util.*;
import java.io.*;

public class Main {
    
    static int MAX = 1000000;
    static int[] count;
    static int[] parent;
    static int[] rank;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        count = new int[MAX+1];
        parent = new int[MAX+1];
        rank = new int[MAX+1];
        
        for (int i = 1; i < parent.length; ++i) {
            count[i] = 1;
            parent[i] = i;
            rank[i] = 0;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else { // ' Q'
                int x = Integer.parseInt(st.nextToken());
                sb.append(count[find(x)]).append("\n");
            }
        }
        
        System.out.print(sb);
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
            count[rootA] += count[rootB];
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
            count[rootB] += count[rootA];
        } else {
            parent[rootA] = rootB;
            count[rootB] += count[rootA];
            rank[rootB]++;
        }
    }

}