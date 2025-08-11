import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
	
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String input = br.readLine();
	    int overlapStickCount = 0; // 겹쳐진 막대기 수
        int count = 0; // 잘린 막대기 수
        char[] array = input.toCharArray();

	    for (int i = 1; i < array.length; ++i) {
	        if (array[i] == '(') {
	            if (array[i-1] == '(') {
	                // 최상위에 막대기 하나가 올라간다.
	                overlapStickCount++;
	            }
	        }
	        else if (array[i] == ')') {
	            if (array[i-1] == '(') { 
	                // 겹쳐진 막대기가 잘린 왼쪽 부분의 개수만큼 더한다.
	                count += overlapStickCount;
	            }
	            else if (array[i-1] == ')') {
	                // 겹쳐진 막대기중 최상위 막대기가 끊긴 상태이므로, 
	                // 잘린 오른쪽 부분의 개수만큼 더한다.
	                count++;
	                overlapStickCount--;
	            }
	        }
	    }
	    
	    bw.write(count + "");
	    bw.flush();
	    
	    bw.close();
	    br.close();
	}

}