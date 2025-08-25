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
        for (int l = 0; l < layers; ++l) {
            int top = l, left = l, bottom = N - 1 - l, right = M - 1 - l;
            int height = bottom - top + 1;
            int width  = right - left + 1;
            int len = 2 * (height + width) - 4;  // 둘레 길이

            int rotateCnt = R % len;  // 필요한 만큼만 회전
            if (rotateCnt == 0) continue;

            // 반시계 한 칸 회전 = 이 배열을 왼쪽으로 1칸 쉬프트
            List<int[]> pos = new ArrayList<>(len);  // 회전시키는 둘레 좌표 순서
            // 위쪽 행 (left → right)
            for (int y = left; y <= right; y++) 
                pos.add(new int[]{top, y});  
            // 오른쪽 열 (top+1 → bottom-1)
            for (int x = top + 1; x <= bottom - 1; x++) 
                pos.add(new int[]{x, right});
            // 아래쪽 행 (right → left)
            if (bottom > top) 
                for (int y = right; y >= left; y--) 
                    pos.add(new int[]{bottom, y});
            // 왼쪽 열 (bottom-1 → top+1)
            if (right > left) 
                for (int x = bottom - 1; x >= top + 1; x--) 
                    pos.add(new int[]{x, left});

            int elements = pos.size();
            int[] buffer = new int[elements];  // 둘레 값을 저장할 배열
            for (int i = 0; i < elements; i++) {
                int x = pos.get(i)[0], y = pos.get(i)[1];
                buffer[i] = arr[x][y];
            }

            // 반시계 rotateCnt칸 회전 -> 왼쪽으로 rotateCnt칸 쉬프트
            for (int i = 0; i < elements; i++) {
                int toIdx = i;  // 쓸 위치
                int fromIdx = (i + rotateCnt) % elements;  // 가져올 값
                int x = pos.get(toIdx)[0];  // row 좌표
                int y = pos.get(toIdx)[1];  // col 좌표
                arr[x][y] = buffer[fromIdx];
            }
        }
    }
}