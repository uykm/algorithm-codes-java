import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] arr;
    static int N, M, K;
    static int[][] operations;
    static boolean[] alreadyProcessed;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        operations = new int[K][3];
        alreadyProcessed = new boolean[K];
        
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            
            operations[i][0] = r;
            operations[i][1] = c;
            operations[i][2] = s;
        }
        
        search(0);
        
        System.out.println(answer);
    }
    
    static void search(int opCount) {
        if (opCount == K) {
            calMinRowSum();
            return;
        }
        
        int[][] original = new int[N][M];
        for (int i = 0; i < N; ++i) {
            original[i] = arr[i].clone();
        }
        
        for (int i = 0; i < K; ++i) {
            if (alreadyProcessed[i]) continue;
            alreadyProcessed[i] = true;
            rotate(operations[i][0], operations[i][1], operations[i][2]);
            search(opCount + 1);
            
            alreadyProcessed[i] = false;
            rollback(original);
        }
    }
    
    static void rotate(int r, int c, int s) {
        for (int l = 1; l <= s; l++) {
            int top = r - l, left = c - l;
            int bottom = r + l, right = c + l;
    
            int temp = arr[top][left];
    
            // 왼쪽 열 위로 당김 (top..bottom-1)
            for (int i = top; i < bottom; i++) {
                arr[i][left] = arr[i + 1][left];
            }
            // 아래 행 왼쪽으로 당김 (left..right-1)
            for (int j = left; j < right; j++) {
                arr[bottom][j] = arr[bottom][j + 1];
            }
            // 오른쪽 열 아래에서 위로 당김 (bottom..top+1 거꾸로)
            for (int i = bottom; i > top; i--) {
                arr[i][right] = arr[i - 1][right];
            }
            // 위 행 오른쪽으로 당김 (right..left+1 거꾸로)
            for (int j = right; j > left + 1; j--) {
                arr[top][j] = arr[top][j - 1];
            }
            // 비워진 자리 채우기
            arr[top][left + 1] = temp;
        }
    }
    
    static void calMinRowSum() {
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < N; ++i){
            int temp = 0;
            for(int j = 0; j < M; ++j) {
                temp += arr[i][j];
            }
            sum = Math.min(sum, temp);
        }
        answer = Math.min(answer, sum);
    }
    
    static void rollback(int[][] original) {
        for(int i = 0; i < N; ++i){
            arr[i] = original[i].clone();
        }
    }
    
}