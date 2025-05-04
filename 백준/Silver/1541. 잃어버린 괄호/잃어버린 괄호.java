import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = 0;
        boolean isMinus = false;
        StringBuilder sb = new StringBuilder();

        for (char c : br.readLine().toCharArray()) {
            if ('0' <= c && c <= '9') {
                sb.append(c);
                continue;
            }

            int num = Integer.parseInt(sb.toString());
            sb = new StringBuilder();

            if (isMinus) {
                min -= num;
            } else {
                min += num;
            }

            if (c == '-') {
                isMinus = true;
            }
        }

        if (sb.length() > 0) {
            if (isMinus) {
                min -= Integer.parseInt(sb.toString());
            } else {
                min += Integer.parseInt(sb.toString());
            }
        }

        System.out.println(min);
    }
}