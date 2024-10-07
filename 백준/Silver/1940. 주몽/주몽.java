import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine());
        int answer = 0;
        
        int[] materials = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materials);
        
        int startIdx = 0, endIdx = materials.length - 1;
        while (startIdx < endIdx) {
            
            int sum = materials[startIdx] + materials[endIdx];
            
            if (sum < M) {
                startIdx++;
            } else if (sum > M) {
                endIdx--;
            } else { // 갑옷 생성
                startIdx++;
                endIdx--;
                answer++;
            }
        }
        
        System.out.print(answer);
    }
}