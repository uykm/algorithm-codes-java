import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 더 작은 인덱스의 원소가 현재 인덱스의 원소보다 더 큰지?
        // 2. 현재 비교하고 있는 원소 값들 중에 어떤 것을 선택했을 때 최대 길이가 될 수 있는지?
        int maxLength = 0; // 감소하는 부분 수열의 최대 길이
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 자기 자신만으로도 감소하는 부분 수열 생성
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) { // 이전 원소가 현재 원소보다 크면 이전 원소부터 부분 수열 길이 계산
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }

        System.out.println(maxLength);
    }

}