import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100000;
    static int N;
    static int K;
    static boolean[] visited;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX + 1];

        bfs(N);

        System.out.println(minTime);
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curX = node.x;
            int time = node.time;
            visited[curX] = true;

            if (curX == K) {
                minTime = Math.min(minTime, time);
            }

            if (curX * 2 <= MAX && !visited[curX * 2]) {
                queue.add(new Node(curX * 2, time));
            }
            if (curX + 1 <= MAX && !visited[curX + 1]) {
                queue.add(new Node(curX + 1, time + 1));
            }
            if (curX - 1 >= 0 && !visited[curX - 1]) {
                queue.add(new Node(curX - 1, time + 1));
            }
        }
    }

    private static class Node {
        int x;
        int time;
        private Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }


}