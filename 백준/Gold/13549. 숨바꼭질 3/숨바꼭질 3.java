import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100000;
    static int[] time = new int[MAX + 1];  // 방문 및 시간 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(time, -1); // -1은 아직 방문 안 함 의미

        bfs(N);
        System.out.println(time[K]);
    }

    // [ 0-1 BFS ]
    // 가중치(걸리는 시간) 0과 1로 이뤄진 그래프에서 최단 경로를 찾는 문제
    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        time[start] = 0;
        deque.add(start);

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            int[] next = {cur * 2, cur - 1, cur + 1};
            for (int i = 0; i < 3; i++) {
                int nx = next[i];

                if (nx < 0 || nx > MAX) continue;
                if (time[nx] != -1) continue;

                // 0초에 가는 경우는 앞에 넣음 (우선 순위 높음)
                if (i == 0) {
                    time[nx] = time[cur];  // 순간이동
                    deque.addFirst(nx);
                } else {
                    time[nx] = time[cur] + 1;
                    deque.addLast(nx);
                }
            }
        }
    }
}