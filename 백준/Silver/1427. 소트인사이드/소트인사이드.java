import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];
        
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = str.charAt(i) - '0';
        }
        
        selectionSort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            sb.append(arr[i]);
        }
        
        System.out.println(sb);
    }
    
    static void selectionSort(int[] arr) {
            
        for (int i = 0; i < arr.length; i++) {
            int tmp = 0;
            int minIdx = i;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        
    }
}