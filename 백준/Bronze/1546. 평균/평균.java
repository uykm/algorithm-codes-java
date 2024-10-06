import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        String[] scores = sc.nextLine().split(" ");
        double max = 0;
        for (int i = 0; i < N; ++i) {
            int tmp = Integer.parseInt(scores[i]);
            max = max < tmp ? tmp : max;
        }
        
        double sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += Double.parseDouble(scores[i]) / max * 100;
        }
        
        System.out.print(sum / N);
    }
}