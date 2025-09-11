import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int COL = Integer.parseInt(br.readLine());
        int ROW = Integer.parseInt(br.readLine());
        
        char[] origin = new char[COL];
        for (int i = 0; i < COL; ++i) {
            origin[i] = (char)('A' + i);
        }
        
        int unknownLine = 0;
        String target = br.readLine();
        char[] result = target.toCharArray();
        
        String[] ladder = new String[ROW];
        
        for (int i = 0; i < ROW; ++i) {
            ladder[i] = br.readLine();
            if (ladder[i].charAt(0) == '?') unknownLine = i;
        }
        
        for (int i = 0; i < unknownLine; ++i) {
            for (int j = 0; j < COL-1; ++j) {
                if (ladder[i].charAt(j) == '-') {
                    char tmp = origin[j];
                    origin[j] = origin[j+1];
                    origin[j+1] = tmp;
                    j++;
                }
            }
        }
        
        for (int i = ROW-1; i > unknownLine; --i) {
            for (int j = 0; j < COL-1; ++j) {
                if (ladder[i].charAt(j) == '-') {
                    char tmp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = tmp;
                    j++;
                }
            }
        }
        
        StringBuilder hidden = new StringBuilder();
        for (int i = 0; i < COL-1; ++i) {
            if (origin[i] == result[i]) {
                hidden.append("*");
            } else if (origin[i] == result[i+1] && origin[i+1] == result[i]) {
                hidden.append("-");
                char t = origin[i];
                origin[i] = origin[i+1];
                origin[i+1] = t;
                // 이후에 바로 origin[i+1], origin[i+2] 스왑 방지
                i++;
                if (i < COL - 1) {
                    hidden.append("*");
                }
            } else {
                System.out.print("x".repeat(COL - 1));
                return;
            }
        }
        
        System.out.print(hidden);
    }
}