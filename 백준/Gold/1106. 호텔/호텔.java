import java.util.*;
import java.io.*;

public class Main{
    
	public static void main(String[] args) throws IOException {
	    
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine());
	    
	    int goal = Integer.parseInt(st.nextToken());
	    int city = Integer.parseInt(st.nextToken());
	    
	    // dp[i]: i명의 고객을 유치하는 데 필요한 최소 비용
	    int[] dp = new int[goal+100];
	    Arrays.fill(dp, (goal+100)*1000);
	    
	    dp[0] = 0;
	    
	    for (int n = 0; n < city; ++n) {
	        st = new StringTokenizer(br.readLine());
	        int cost = Integer.parseInt(st.nextToken());;  // 홍보 비용
	        int customer = Integer.parseInt(st.nextToken());;  // 얻을 수 있는 고객 수
	        
	        for (int i = customer; i < goal+100; ++i) {
	            dp[i] = Math.min(dp[i], dp[i-customer] + cost);
	        }
	    }

        int minCost = Integer.MAX_VALUE;	    
	    for (int i = goal; i < goal + 100; ++i) {
	        minCost = Math.min(minCost, dp[i]);
	    }
	    
	    System.out.println(minCost);
	}
}
