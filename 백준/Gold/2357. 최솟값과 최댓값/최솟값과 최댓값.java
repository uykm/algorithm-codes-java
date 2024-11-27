import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 정수 개수
        int M = Integer.parseInt(st.nextToken()); // 쿼리 개수

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 세그먼트 트리 초기화
        minTree = new int[4 * N];
        maxTree = new int[4 * N];
        buildMinTree(0, N - 1, 1);
        buildMaxTree(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int minValue = queryMin(0, N - 1, 1, a, b);
            int maxValue = queryMax(0, N - 1, 1, a, b);
            sb.append(minValue).append(" ").append(maxValue).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 최소값 세그먼트 트리 구성
    static int buildMinTree(int start, int end, int node) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        int leftMin = buildMinTree(start, mid, node * 2);
        int rightMin = buildMinTree(mid + 1, end, node * 2 + 1);
        return minTree[node] = Math.min(leftMin, rightMin);
    }

    // 최대값 세그먼트 트리 구성
    static int buildMaxTree(int start, int end, int node) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        int leftMax = buildMaxTree(start, mid, node * 2);
        int rightMax = buildMaxTree(mid + 1, end, node * 2 + 1);
        return maxTree[node] = Math.max(leftMax, rightMax);
    }

    // 최소값 구간 쿼리
    static int queryMin(int start, int end, int node, int L, int R) {
        if (R < start || end < L) { // 범위 밖
            return Integer.MAX_VALUE;
        }
        if (L <= start && end <= R) { // 범위 완전 포함
            return minTree[node];
        }
        int mid = (start + end) / 2;
        int leftMin = queryMin(start, mid, node * 2, L, R);
        int rightMin = queryMin(mid + 1, end, node * 2 + 1, L, R);
        return Math.min(leftMin, rightMin);
    }

    // 최대값 구간 쿼리
    static int queryMax(int start, int end, int node, int L, int R) {
        if (R < start || end < L) { // 범위 밖
            return Integer.MIN_VALUE;
        }
        if (L <= start && end <= R) { // 범위 완전 포함
            return maxTree[node];
        }
        int mid = (start + end) / 2;
        int leftMax = queryMax(start, mid, node * 2, L, R);
        int rightMax = queryMax(mid + 1, end, node * 2 + 1, L, R);
        return Math.max(leftMax, rightMax);
    }
}