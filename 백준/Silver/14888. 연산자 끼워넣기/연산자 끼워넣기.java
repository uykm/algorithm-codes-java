import java.util.*;
import java.io.*;

public class Main {
    
    static int[] num;
    static int[] operators = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
		    num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; ++i) {
		    operators[i] = Integer.parseInt(st.nextToken());
		}
		
		updateMaxMinValue(num[0], 1);
		
		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
		
		br.close();
	}
	
	private static void updateMaxMinValue(int value, int index) {
	    
	    // 모든 연산자를 끼워넣은 결과값과 기존 최댓값/최솟값 비교
	    if (index == N) {
	        max = Math.max(max, value);
	        min = Math.min(min, value);
	        return;
	    }
	    
	    for (int i = 0; i < 4; ++i) {
	        if (operators[i] > 0) {
	            
	            operators[i]--; // 연산자 1개 사용
	            
	            switch (i) {
	                case 0: updateMaxMinValue(value + num[index], index + 1); break;
	                case 1: updateMaxMinValue(value - num[index], index + 1); break;
	                case 2: updateMaxMinValue(value * num[index], index + 1); break;
	                case 3: updateMaxMinValue(value / num[index], index + 1); break;
	            }
	            
	            operators[i]++; // 백트래킹에 사용한 연산자 복구
	        }
	    }
	}
	
}