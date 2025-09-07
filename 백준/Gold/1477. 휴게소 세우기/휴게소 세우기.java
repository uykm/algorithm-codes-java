import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L;
    static int[] rest;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rest = new int[N + 2];  // 0과 L 포함
        rest[0] = 0;
        rest[N + 1] = L;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rest[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            // N=0이면 두 번째 줄이 없을 수도 있으니 주의 (BOJ는 보통 빈 줄 안 줌)
            // 아무 것도 안 읽어도 됨
        }

        Arrays.sort(rest);

        // 이진 탐색: 가능한 최대 간격의 최소값
        int lo = 1;                // 최대 간격은 최소 1
        int hi = L;                // 최대 간격은 최악에 L
        int ans = L;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;   // 후보 최대 간격

            long need = 0;
            for (int i = 0; i <= N; i++) {
                int d = rest[i + 1] - rest[i];  // 구간 길이
                if (d > mid) {
                    // (d-1)/mid == ceil(d/mid) - 1와 동일 효과
                    need += (d - 1) / mid;
                    if (need > M) break; // 가지치기
                }
            }

            if (need <= M) {
                ans = mid;      // 가능 → 더 줄여본다
                hi = mid - 1;
            } else {
                lo = mid + 1;   // 불가능 → 더 늘린다
            }
        }

        System.out.println(ans);
    }
}