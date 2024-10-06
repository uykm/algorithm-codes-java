import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        int[] targets = new int[n]; // 수열
        for(int i = 0; i < n; ++i) {
            targets[i] = Integer.parseInt(br.readLine());
        }
        
        int num = 1;
        int targetIdx = 0;
        StringBuilder sb = new StringBuilder();
        while(num <= n || !stack.isEmpty()) {
            
            if (!stack.empty() && stack.peek() == targets[targetIdx]) { 
                stack.pop();
                sb.append("-\n");
                targetIdx++;
                continue;
            }
            
            if(num > n) break;
            
            stack.push(num++);
            sb.append("+\n");
        }
        
        if (stack.isEmpty()) {
            System.out.print(sb);
        } else {
            System.out.print("NO");
        }
    }
}