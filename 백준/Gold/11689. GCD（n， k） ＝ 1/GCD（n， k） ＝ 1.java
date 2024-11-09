import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.print(eulerphi(n));
    }
    
    public static long eulerphi(long n) {
        long count = n;  // 최대 공약수가 한 개인 수들의 개수
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                count -= count / i;
            }
        }
        
        if (n > 1) {
            count -= count / n;
        }
        
        return count;
    }
}