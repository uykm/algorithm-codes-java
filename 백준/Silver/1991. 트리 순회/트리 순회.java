import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
	
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 개수

        BinaryTree tree = new BinaryTree();

        // 입력 받아 트리 구성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.addNode(data, left, right);
        }

        // 루트 노드
        Node root = tree.nodes.get('A');

        // 순회 결과 출력
        StringBuilder sb = new StringBuilder();

        // 전위 순회
        tree.preorder(root, sb);
        System.out.println(sb.toString());
        sb.setLength(0); // StringBuilder 초기화

        // 중위 순회
        tree.inorder(root, sb);
        System.out.println(sb.toString());
        sb.setLength(0); // StringBuilder 초기화

        // 후위 순회
        tree.postorder(root, sb);
        System.out.println(sb.toString());
    }

    static class Node {
        char data;
        Node left, right;
        
        Node(char data) {
            this.data = data;
            left = right = null;
        }
    }
    
    static class BinaryTree {
        Map<Character, Node> nodes = new HashMap<>(); // 노드 저장

        // 트리 구성
        void addNode(char data, char left, char right) {
            Node node = nodes.getOrDefault(data, new Node(data));
            nodes.put(data, node);

            if (left != '.') { // 왼쪽 자식이 있는 경우
                Node leftNode = new Node(left);
                nodes.put(left, leftNode);
                node.left = leftNode;
            }
            if (right != '.') { // 오른쪽 자식이 있는 경우
                Node rightNode = new Node(right);
                nodes.put(right, rightNode);
                node.right = rightNode;
            }
        }

        // 전위 순회
        void preorder(Node node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.data);      // 루트 방문
            preorder(node.left, sb);   // 왼쪽 서브트리
            preorder(node.right, sb);  // 오른쪽 서브트리
        }

        // 중위 순회
        void inorder(Node node, StringBuilder sb) {
            if (node == null) return;
            inorder(node.left, sb);    // 왼쪽 서브트리
            sb.append(node.data);      // 루트 방문
            inorder(node.right, sb);   // 오른쪽 서브트리
        }

        // 후위 순회
        void postorder(Node node, StringBuilder sb) {
            if (node == null) return;
            postorder(node.left, sb);  // 왼쪽 서브트리
            postorder(node.right, sb); // 오른쪽 서브트리
            sb.append(node.data);      // 루트 방문
        }
    }
    
}