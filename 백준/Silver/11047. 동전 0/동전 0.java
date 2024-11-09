import java.util.*;
import java.io.*;

public class Main {
    
    static int[] coins; // 종류별 동전의 가치
    static int target;  // 가치의 합 K
    
    public static void main(String[] args) throws Exception {
        
        int answer = 0; // 필요한 동전 개수의 최솟값
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int count = Integer.parseInt(st.nextToken()); // 동전 종류 개수
        coins = new int[count];
        target = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < coins.length; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int sum = 0;
        count--;
        
        while (sum != target) {
            
            int tmp = sum;
            tmp += coins[count];
            
            if (tmp > target) {
                count--;  // 한 단계 낮은 가치의 동전으로
            } else {
                sum = tmp;
                answer++;            
            }
        }
        
        System.out.print(answer);
    }
}