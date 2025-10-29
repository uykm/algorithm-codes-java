import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();

        calOddNumByCut(N, 0);
        
        System.out.println(min + " " + max);
    }
    
    static void calOddNumByCut(String numString, int cnt) {
        cnt += countOddNum(numString);
        
        int digit = numString.length();
        
        if (digit == 1) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        } 
        else if (digit == 2) {
            String[] splitNum = numString.split("");
            int a = Integer.parseInt(splitNum[0]);
            int b = Integer.parseInt(splitNum[1]);
    
            calOddNumByCut(String.valueOf(a + b), cnt);
        }
        else {
            for (int i = 0; i < numString.length() - 2; ++i) {
                for (int j = i+1; j < numString.length() - 1; ++j) {
                    int next = Integer.parseInt(numString.substring(0, i+1));
    				next += Integer.parseInt(numString.substring(i+1, j+1));
    				next += Integer.parseInt(numString.substring(j+1));
    				
    				calOddNumByCut(String.valueOf(next), cnt);
                }
            }
        }
    }
    
    static int countOddNum(String n) {
        int cnt = 0;
        for (char ch : n.toCharArray()) {
            int num = ch - '0';
            if (num % 2 != 0)  {
                cnt++;
            }
        }
        return cnt;
    }

}