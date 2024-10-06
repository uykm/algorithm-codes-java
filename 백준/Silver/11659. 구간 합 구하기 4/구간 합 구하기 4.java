import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 구간 합을 구해야 하는 횟수
        
        int[] sumArr = new int[N + 1]; // sumArr[k] 1번째 숫자부터 k번째 숫자까지의 합
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < N + 1; ++i) {
            sumArr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] += sumArr[i-1];
        }
        
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // i번째 수부터
            int end = Integer.parseInt(st.nextToken());   // j번째 수까지
            
            System.out.println(sumArr[end] - sumArr[start - 1]);
            
            M--;
        }
	    
	}
}
