import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Map<Integer, Integer> count = new TreeMap<>();  // 자동 정렬을 위해 TreeMap 사용
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            for (int day = start; day <= end; day++) {
                count.put(day, count.getOrDefault(day, 0) + 1);
            }
        }
        
        int sum = 0;
        int width = 0, height = 0;
        int prevDay = -1;
        
        for (int day : count.keySet()) {
            // 연속되지 않은 경우, 코팅지 면적 게산
            if (prevDay != -1 && day != prevDay + 1) {
                sum += height * width;
                height = width = 0;
            }
            
            width++;
            height = Math.max(height, count.get(day));
            prevDay = day;
        }
        
        // 마지막 코팅지 처리
        sum += height * width;
        
        System.out.println(sum);
    }
}