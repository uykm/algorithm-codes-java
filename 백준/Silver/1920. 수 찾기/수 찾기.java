import java.util.*;
import java.io.*;

public class Main {
    
    static int N; // 배열 A 안의 정수 개수
    static int M; // 탐색해야 하는 정수 개수
    static int[] A;
    static int[] nums;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A); // 이진탐색은 항상 정렬부터 해줘야 한다.
        
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[M];
        for (int i = 0; i < M; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            if (binarySearch(A, num)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static boolean binarySearch(int[] arr, int target) {
         
        int startIdx = 0;
        int endIdx = arr.length - 1;
         
        while (startIdx <= endIdx) {
            
            int midIdx = (startIdx + endIdx) / 2;
            
            if (arr[midIdx] < target) {
                startIdx = (startIdx + endIdx) / 2 + 1;
            } else if (arr[midIdx] > target) {
                endIdx = (startIdx + endIdx) / 2 - 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}