import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L, P, V;
        List<Integer> answer = new ArrayList<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // P 기간동안 이용 가능한 일수
            P = Integer.parseInt(st.nextToken()); // 연속하는 기간
            V = Integer.parseInt(st.nextToken()); // 휴가일수

            if (L == 0 && P == 0 && V == 0) break;

            answer.add(
                    (V / P) * L + Math.min(V % P, L)
            );
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println("Case " + (i + 1) + ": " + answer.get(i));
        }

    }
}