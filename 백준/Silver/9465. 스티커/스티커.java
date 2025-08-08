import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int row = 2;

        /**
         * 점화식
         * sum[j][k] = sum[j][k-2] + stickers[(j+1) % 2][k-1] + stickers[j][k]
         * sum[j][k] = sum[(j+1) % 2][k-2] + stickers[j][k-1]
         * sum[j][k] = sum[(j+1) % 2][k-2] + stickers[j][k]
         */
        for (int i = 0; i < t; i++) {
            int col = Integer.parseInt(br.readLine());
            int[][] stickers = new int[row][col+1];
            int[][] dp = new int[row][col+1];

            for (int j = 0; j < row; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= col; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int k = 2; k <= col; ++k) {
                for (int j = 0; j < row; ++j) {
                    dp[j][k] = Math.max(dp[j][k-2] + stickers[(j+1) % 2][k-1] + stickers[j][k],
                            dp[(j+1) % 2][k-2] + stickers[j][k-1]);
                    dp[j][k] = Math.max(dp[j][k], dp[(j+1) % 2][k-2] + stickers[j][k]);
                }
            }

            int max = Math.max(dp[0][col], dp[1][col]);
            System.out.println(max);
        }
    }
}