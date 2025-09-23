import java.util.*;
import java.io.*;

public class Main
{

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int N = Integer.parseInt(br.readLine());
	    int[][] towns = new int[N][2];
	    
	    long midPopulation = 0;
	    for (int i = 0; i < N; ++i) {
	        st = new StringTokenizer(br.readLine());
	        towns[i][0] = Integer.parseInt(st.nextToken());
	        towns[i][1] = Integer.parseInt(st.nextToken());
	        midPopulation += towns[i][1];
	    }
	    
	    Arrays.sort(towns, (a, b) ->  a[0] - b[0]);
	    
	    midPopulation = (midPopulation + 1)/2;
	    
	    long sum = 0;
	    for (int i = 0; i < N; ++i) {
	        sum += towns[i][1];
	        if (sum >= midPopulation) {
	            System.out.print(towns[i][0]);
	            break;
	        }
	    }
	}
}
