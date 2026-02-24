import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 0;
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; ++i) {
		    st = new StringTokenizer(br.readLine());
		    arr[i][0] = Integer.parseInt(st.nextToken()); // 필요한 시간
		    arr[i][1] = Integer.parseInt(st.nextToken()); // 배점
		}
		
		// dp[i] = i 시간을 썼을 때 얻을 수 있는 최대 점수.
		int[] dp = new int[T+1];
		for (int[] a : arr) {
		    int requiredTime = a[0];
		    int score = a[1];
		    
		    for (int i = T; i >= requiredTime; i--) {
		        dp[i] = Math.max(dp[i], dp[i-requiredTime] + score);
		    }
		}
		
		System.out.println(dp[T]);
	}
}
