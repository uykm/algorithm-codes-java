import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];
        
        for (int i = 0; i < N; ++i) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);
        
        int answer = 0;        
        int min = 1;
        int max = houses[N-1] - houses[0] + 1;
        
        while (min <= max) {
            int cnt = 1;
            int cur = houses[0];
            
            // 시험해보고자 하는 가장 인접한 두 공유기 사이의 거리
            int minDistance = (min + max) / 2; 
            
            for (int i = 1; i < N; ++i) {
                // minDistance 이상의 거리를 두고 다음 공유기를 설치할 수 있는지 테스트 
                if (houses[i] - cur >= minDistance) {
                    cnt++;
                    cur = houses[i]; // 현재 공유기를 설치한 집으로 이동
                }
            }
            
            if (cnt >= C) {
                answer = minDistance;
                min = minDistance + 1;
            } else {
                max = minDistance - 1;
            }
        }
        
        System.out.println(answer);
    }

}