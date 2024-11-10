import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long aCount = Long.parseLong(st.nextToken());
        long bCount = Long.parseLong(st.nextToken());
        
        // GCD는 1의 개수가 작은 쪽에 해당하는 숫자이므로, 간단히 계산
        long gcdCount = GCD(aCount, bCount);
        
        // 결과 출력: 1의 개수가 gcdCount인 문자열 생성
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < gcdCount; i++) {
            sb.append("1");
        }
        System.out.print(sb.toString());
    }
    
    public static long GCD(long n1, long n2) {
        if (n2 == 0) return n1;
        return GCD(n2, n1 % n2);
    }   
}