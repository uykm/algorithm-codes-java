import java.io.*;
import java.util.*;


public class Main {

    static final int MOD = 1_000_000_007;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(binomialCoefficient());
    }

    public static long binomialCoefficient() {
        if (K > N) return 0;
        if (K == 0 || K == N) return 1;

        long[] factorial = new long[N + 1];
        factorial[0] = 1;

        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        long numerator = factorial[N];
        long denominator = (factorial[K] * factorial[N - K]) % MOD;

        return numerator * modInverse(denominator, MOD) % MOD;
    }

    public static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    public static long power(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}