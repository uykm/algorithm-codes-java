import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        Arrays.sort(lectures, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            int start = lectures[i][0];
            int end = lectures[i][1];

            if (!pq.isEmpty()  && pq.peek() <= start) { // 이어서 쓸 강의실이 있는 경우
                pq.poll();
            }

            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}