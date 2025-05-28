import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2]; // dp[i]: i일까지의 최대 수익
        int[][] schedule = new int[N + 1][2]; // schedule[N+1][0] = 0, schedule[N+1][1] = 0

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            schedule[i] = new int[]{day, pay};
        }

        // 1. 현재 날짜에 상담을 할 수 있는지?
        // 2. 이전 날짜의 최대 수익을 현재 날짜에 적용
        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);  // 이전 최대값 가져오기

            if (i <= N) {
                int requiredDay = schedule[i][0];
                int requiredPay = schedule[i][1];
                int nextDay = i + requiredDay;

                if (nextDay <= N + 1) {
                    dp[nextDay] = Math.max(dp[nextDay], dp[i] + requiredPay);
                }
            }
        }

        System.out.println(dp[N + 1]);
    }
}