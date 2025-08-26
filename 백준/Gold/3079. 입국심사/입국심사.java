import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] tables;
    static long minTime = Long.MAX_VALUE;
    static long maxTime = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tables = new int[N];
        for (int i = 0; i < N; i++) {
            tables[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, tables[i]);
        }
        
        binarySearch();
        
        System.out.print(minTime);
    }
    
    static void binarySearch() {
        long start = 0;
        long end = maxTime * M;
        while (start <= end) {
            long mid = (start + end) / 2;
            long personCnt = 0;
            for (int i = 0; i < N; ++i) {
                personCnt += mid / tables[i];
                if (personCnt >= M) break; // 추가
            }
            
            if (personCnt >= M) {
                end = mid - 1;
                minTime = Math.min(minTime, mid);
            }
            else {
                start = mid + 1; 
            }
        }
    }
}