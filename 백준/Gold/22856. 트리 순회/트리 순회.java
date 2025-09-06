import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BinaryTree bt = new BinaryTree();

        for (int i = 0; i < N; ++i) {
            var st = new StringTokenizer(br.readLine());
            int parentData = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            Node parent = bt.insertNode(parentData);
            bt.insertLeft(left, parent);
            bt.insertRight(right, parent);
        }

        int moveCnt = 2 * (bt.getNodeCnt() - 1) - bt.depthOfRightmost();

        System.out.print(moveCnt);
    }

    static class Node {
        int data;
        Node left, right;
        Node(int data) { 
            this.data = data; 
        }
    }

    static class BinaryTree {
        private final Map<Integer, Node> nodeMap = new HashMap<>();
        private int nodeCnt = 0;
        private int root = 1;

        public int getNodeCnt() { return nodeCnt; }
        
        public Node insertNode(int data) {
            Node n = nodeMap.get(data);
            if (n != null) { return n; }
            Node newNode = new Node(data);
            nodeMap.put(data, newNode);
            nodeCnt++;
            return newNode;
        }

        public void insertLeft(int data, Node parent) {
            if (data == -1) return;
            Node newNode = insertNode(data);
            parent.left = newNode;
        }
        
        public void insertRight(int data, Node parent) {
            if (data == -1) return;
            Node newNode = insertNode(data);
            parent.right = newNode;
        }

        public int depthOfRightmost() {
            int depth = 0;
            Node cur = nodeMap.get(root);
            while (cur != null && cur.right != null) {
                cur = cur.right;
                depth++;
            }
            return depth;
        }
    }
}