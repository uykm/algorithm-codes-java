import java.io.*;
import java.util.*;

public class Main {
	//엣지리스트 생성
    static int[][] graph;
    //부모 노드
    static int[] parent;
    //최종값
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new int[E][3];
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        parent = new int[V+1];
        for(int i=1; i<V+1; i++){
            parent[i] = i;
        }

        kruskal(graph, parent);
    }

    static void kruskal(int[][] graph, int[] parent){
        total = 0;
        for(int i=0; i<graph.length; i++){
            if(find(parent, graph[i][0]) != find(parent, graph[i][1])){
                total += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }
        System.out.println(total);
    }

    static void union(int[] parent, int i, int j){
        i = find(parent, i);
        j = find(parent, j);
        if(i<j){
            parent[j] = i;
        }else{
            parent[i] = j;
        }
    }

    static int find(int[] parent, int i){
        if(parent[i] != i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}