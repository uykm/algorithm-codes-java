import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        rotateAllLayers(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(arr[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void rotateAllLayers(int R) {
        int layers = Math.min(N, M) / 2;
        for (int s = 0; s < layers; s++) {
            int top = s, left = s, bottom = N - 1 - s, right = M - 1 - s;
            int height = bottom - top + 1;
            int width  = right - left + 1;
            int len = 2 * (height + width) - 4;   // 둘레 길이

            int k = R % len;                      // 필요한 만큼만 회전
            if (k == 0) continue;

            // 둘레를 시계 방향 순서로 뽑는다 (위→오른→아래→왼)
            // 반시계 한 칸 회전 = 이 배열을 "왼쪽으로 1칸" 시프트
            List<int[]> pos = new ArrayList<>(len);
            // 위쪽 행 (left → right)
            for (int y = left; y <= right; y++) pos.add(new int[]{top, y});
            // 오른쪽 열 (top+1 → bottom-1)
            for (int x = top + 1; x <= bottom - 1; x++) pos.add(new int[]{x, right});
            // 아래쪽 행 (right → left)
            if (bottom > top) for (int y = right; y >= left; y--) pos.add(new int[]{bottom, y});
            // 왼쪽 열 (bottom-1 → top+1)
            if (right > left) for (int x = bottom - 1; x >= top + 1; x--) pos.add(new int[]{x, left});

            int L = pos.size();
            int[] buf = new int[L];
            for (int i = 0; i < L; i++) {
                int x = pos.get(i)[0], y = pos.get(i)[1];
                buf[i] = arr[x][y];
            }

            // 반시계 k칸 회전 → 왼쪽으로 k칸 쉬프트
            for (int i = 0; i < L; i++) {
                int toIdx = i;                  // 쓸 위치
                int fromIdx = (i + k) % L;      // 가져올 값
                int x = pos.get(toIdx)[0], y = pos.get(toIdx)[1];
                arr[x][y] = buf[fromIdx];
            }
        }
    }
}