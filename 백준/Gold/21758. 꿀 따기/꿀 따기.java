import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] honeys = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; ++i) {
            honeys[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] toRightPrefixSum = new int[N+2];  // 벌이 왼쪽 방향으로 가는 경우
        int[] toLeftPrefixSum = new int[N+2];   // 벌이 오른쪽 방향으로 가는 경우
        
        for (int i = 1; i <= N; ++i) {
            toRightPrefixSum[i] = toRightPrefixSum[i-1] + honeys[i];
            toLeftPrefixSum[N-i+1] = toLeftPrefixSum[N-i+2] + honeys[N-i+1];
        }
        
        int maxHoney = 0;
        
        // 오른쪽 끝에 벌통, 왼쪽 끝에 벌 하나
        for (int i = 2; i < N; ++i) {
            // 왼쪽 끝에 있는 벌
            int toRightBee1 = toRightPrefixSum[N] - honeys[1] - honeys[i];
            // 이동시키는 벌
            int toRightBee2 = toRightPrefixSum[N] - toRightPrefixSum[i];
            maxHoney = Math.max(maxHoney, toRightBee1 + toRightBee2);
        }
        
        // 왼쪽 끝에 벌통, 오른쪽 끝에 벌 하나
        for (int i = N-1; i >= 2; --i) {
            // 오른쪽 끝에 있는 벌
            int toLeftBee1 = toLeftPrefixSum[1] - honeys[N] - honeys[i];
            // 이동시키는 벌
            int toLeftBee2 = toLeftPrefixSum[1] - toLeftPrefixSum[i];
            maxHoney = Math.max(maxHoney, toLeftBee1 + toLeftBee2);
        }
        
        // 벌통이 중간에 있고, 벌이 양 끝에 있는 경우
        for (int i = 2; i < N; ++i) {
            int toRightBee = toRightPrefixSum[i] - honeys[1];
            int toLeftBee = toLeftPrefixSum[i] - honeys[N];
            maxHoney = Math.max(maxHoney, toRightBee + toLeftBee);
        }
        
        System.out.print(maxHoney);
    }
}