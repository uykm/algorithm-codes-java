import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder max =  new StringBuilder();

        int digit = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'M') {
                digit++;
            }
            else {
                max.append('5');
                for (int i = 0; i < digit; i++) {
                    max.append('0');
                }
                digit = 0;
            }
        }

        // M으로 끝나는 경우
        if (digit != 0) {
            for (int i = 0; i < digit; i++) {
                max.append('1');
            }
        }

        StringBuilder min =  new StringBuilder();

        boolean isContinuousM = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'M') {
                if (isContinuousM) {
                    min.append('0');
                    continue;
                }
                min.append('1');
                isContinuousM = true;
            }
            else {
                min.append('5');
                isContinuousM = false;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }

}