import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String input = sc.nextLine();
        
        int sum = 0;
        for (int i = 0; i < input.length(); ++i) {
            sum += input.charAt(i) - '0';
        }
        
        System.out.print(sum);
    }
}