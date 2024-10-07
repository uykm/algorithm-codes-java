import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        int answer = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int dnaLen = Integer.parseInt(st.nextToken());
        int pwdLen = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();
        
        int[] agctCondition = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            agctCondition[i] = Integer.parseInt(st.nextToken());
        }
        
        // (초기값) DNA 문자열 0~pwdLen 만큼의 부분 문자열에서의 A,G,C,T 개수
        int[] agctWindow = new int[4]; 
        for (int i = 0; i < pwdLen; ++i) {
            
            if (dna[i] == 'A') agctWindow[0]++;
            if (dna[i] == 'C') agctWindow[1]++;
            if (dna[i] == 'G') agctWindow[2]++;
            if (dna[i] == 'T') agctWindow[3]++;
        }
        
        boolean flag = true;
        for (int i = 0; i < 4; ++i) {
            if (agctCondition[i] > agctWindow[i]) {
                flag = false;
                break;
            }
        }
        
        if (flag) answer++;
        
        for (int tail = pwdLen; tail < dnaLen; ++tail) {
            
            int head = tail - pwdLen;
            flag = true;
            
            // 한 칸 뒤로 움직인 이후의 문자열
            if (dna[head] == 'A') agctWindow[0]--;
            if (dna[head] == 'C') agctWindow[1]--;
            if (dna[head] == 'G') agctWindow[2]--;
            if (dna[head] == 'T') agctWindow[3]--;
            
            if (dna[tail] == 'A') agctWindow[0]++;
            if (dna[tail] == 'C') agctWindow[1]++;
            if (dna[tail] == 'G') agctWindow[2]++;
            if (dna[tail] == 'T') agctWindow[3]++;
            
                
            for (int i = 0; i < 4; ++i) {
                if (agctCondition[i] > agctWindow[i]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }

        System.out.print(answer);
    }
}