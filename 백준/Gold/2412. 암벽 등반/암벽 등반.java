import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] holes;
    static int n, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        holes = new ArrayList[T + 1];
        for (int i = 0; i <= T; ++i) holes[i] = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (0 <= y && y <= T) holes[y].add(x);
        }

        System.out.print(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0}); // (x=0, y=0)에서 시작
        int move = 0;

        // (0,0)이 실제 구멍이면 한 번에 제거해서 중복방문 방지
        if (0 <= T) {
            Iterator<Integer> it0 = holes[0].iterator();
            while (it0.hasNext()) {
                if (it0.next() == 0) { it0.remove(); break; }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int[] cur = q.poll();
                int cx = cur[0], cy = cur[1];

                if (cy == T) return move;

                for (int ny = cy - 2; ny <= cy + 2; ++ny) {
                    if (ny < 0 || ny > T) continue;
                    List<Integer> list = holes[ny];
                    if (list.isEmpty()) continue;

                    // 사용한 홈은 바로 제거
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        int nx = it.next();
                        if (Math.abs(nx - cx) <= 2) {
                            q.offer(new int[]{nx, ny});
                            it.remove();
                        }
                    }
                }
            }
            move++;
        }
        return -1;
    }
}