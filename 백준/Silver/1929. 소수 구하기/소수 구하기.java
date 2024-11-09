import java.util.*;
import java.io.*;

public class Main {
    
    static int[] nums;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        nums = new int[end - start + 1];
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = start++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            if (num == 0 || num == 1) {
                continue;
            }
            else if (isPrime(num)) {
                sb.append(num + "\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    public static boolean isPrime(int n){
            
    	for(int i = 2; i <= Math.sqrt(n); ++i) { // 2부터 n의 제곱근까지의 모든 수를 확인
    	    if (n % i == 0) return false;
    	}
    	
    	return true;
    }
}