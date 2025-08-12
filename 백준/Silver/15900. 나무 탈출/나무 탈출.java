import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int totalDepth = 0;
    static List<List<Integer>> tree = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    for (int i = 0; i <= N; ++i) {
	        tree.add(new ArrayList<>());
	    }
	    
	    for (int i = 0; i < N-1; ++i) {
	        st = new StringTokenizer(br.readLine());
	        int node1 = Integer.parseInt(st.nextToken());
	        int node2 = Integer.parseInt(st.nextToken());
	        tree.get(node1).add(node2);
	        tree.get(node2).add(node1);
	    }
	    
	    calculateTotalDepth(0, 1, 0);
	    
	    bw.write((totalDepth % 2) == 0 ? "No" : "Yes");
	    bw.flush();
	    
	    bw.close();
	    br.close();
	}
	
	public static void calculateTotalDepth(int depth, int currentNode, int parent) {
	    
	    for (int child : tree.get(currentNode)) {
	       if (child != parent) {
	           calculateTotalDepth(depth+1, child, currentNode);
	       }
	    }
	    
	    if (currentNode != 1 && tree.get(currentNode).size() == 1) {
	        totalDepth += depth;
	    }
	}

}