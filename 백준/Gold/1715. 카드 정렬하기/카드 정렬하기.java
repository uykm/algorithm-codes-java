import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int total = 0;

        while (pq.size() > 1) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            int minSum = min1 + min2;
            total += minSum;
            pq.offer(minSum);
        }

        System.out.println(total);
    }
}