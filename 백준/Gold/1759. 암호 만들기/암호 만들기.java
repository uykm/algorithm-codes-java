import java.util.*;
import java.io.*;
    
public class Main {
    static int L, C;
    static char[] code;
    static char[] chArr;
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        code = new char[L];
        chArr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; ++i)
            chArr[i] = st.nextToken().charAt(0);
        
        Arrays.sort(chArr);
        
        dfs(0, 0);
	}
	
	public static void dfs(int depth, int start) {
	    if (depth == L) {
	        if (isValid(code)) {
	            for (char c : code) {
	                System.out.print(c);
	            }
	            System.out.println();
	        }
	        return;
	    }
	    for (int i = start; i < C; ++i) {
	        code[depth] = chArr[i];
	        dfs(depth+1, i+1);
	    }
	}
	
	public static boolean isValid(char[] code) {
	    int c = 0; // 자음 수
	    int v = 0; // 모음 수
	    for (int i = 0; i < code.length; ++i) {
	        if (code[i] == 'a' || code[i] == 'e' || code[i] == 'i' ||
	           code[i] == 'o' || code[i] == 'u') {
	            v++;
	        } else {
	            c++;
	        }
	    }
	    if (c >= 2 && v >= 1) {
	        return true;
	    } else {
	        return false;
	    }
	}
}
