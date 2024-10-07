import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1; // N값
        
        int start = 1;
        while (start <= N / 2) {
            int sum = 0;
            int i = start;
            while (sum < N) {
                sum += i;
                i++;
            }
            if (sum == N) answer++;
            start++;
        }
        
        System.out.print(answer);
        
    }
}