import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        int min = 0; // 최솟값
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int num = 0;  // 문자열을 변환한 값
        boolean isSub = false;
        StringBuilder sb = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            
            if ('0' <= c && c <= '9') {
                sb.append(c);
                continue;
            }
            
            num = Integer.parseInt(sb.toString());  // 연산자 사이에 있는 값
            
            if (isSub) min -= num;
            else min += num;
            
            // c가 '-'인 경우 그 뒤에 나오는 값은 모두 뺴준다는 접근
            if (c == '-') isSub = true;
            
            sb = new StringBuilder();  // sb 초기화
        }
        
        num = Integer.parseInt(sb.toString()); // 마지막 값
        
        // 마지막 값 처리
        if (isSub) {
             min -= num;
        } else {
            min += num;
        }
        
        System.out.print(min);
    }
}