import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        /*
         * 작은 절대값을 높은 우선순위로 처리.
         * 절대값이 같은 경우엔 실수값이 가장 작은 값을 높은 우선순위로 처리.
        */
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            (a, b) -> Math.abs(a) - Math.abs(b) == 0 ? a - b : Math.abs(a) - Math.abs(b)
            );
        // (new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         int absCompare = Math.abs(a) - Math.abs(b);
        //         if (absCompare == 0) {
        //             return a - b; // 절대값이 같을 때는 실수값으로 비교
        //         }
        //         return absCompare;
        //     }
        // });
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; ++i) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.size() == 0) sb.append("0\n");
                else sb.append(queue.poll()).append("\n");
            } else {
                queue.add(x);
            }
        }
        
        System.out.print(sb);
    }
}