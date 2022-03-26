import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1086
public class Boj1086 {
    public static int n, k;
    public static String[] a = new String[15];
    public static int[][] info = new int[15][2];
    public static int[] tenExp = new int[751];
    public static long[][] dp = new long[1 << 15][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < (1 << 15); i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = -1;
            }
        }
        tenExp[0] = 1;
        tenExp[1] = 10 % k;
        for (int i = 2; i <= 750; i++) {
            tenExp[i] = (tenExp[1] * tenExp[i - 1]) % k;
        }
        for (int i = 0; i < n; i++) {
            info[i][0] = findRemainder(a[i]);
            info[i][1] = a[i].length();
        }
        long sum = findCase(0, 0, 0, 0);
        long denominator = fact(n);
        if (sum == denominator) {
            System.out.println("1/1");
            return;
        }
        if (sum == 0) {
            System.out.println("0/1");
            return;
        }
        long temp = gcd(sum, denominator);
        sum /= temp;
        denominator /= temp;
        System.out.println(sum + "/" + denominator);
    }

    private static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }


    private static long fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fact(n - 1) * n;
    }

    private static long findCase(int r, int mask, int length, int depth) {
        if (depth == n) {
            if (r == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if (dp[mask][r] != -1) {
            return dp[mask][r];
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 0) {
                sum += findCase((r + info[i][0] * tenExp[length]) % k, mask | (1 << i), length + info[i][1], depth + 1);
            }
        }
        return dp[mask][r] = sum;
    }

    private static int findRemainder(String s) {
        if (s.length() <= 9) {
            return Integer.parseInt(s) % k;
        }
        int mid1 = s.length() / 2;
        int mid2 = (s.length() + 1) / 2;
        String x, y;
        x = s.substring(0, mid1);
        y = s.substring(mid1, s.length());
        return (findRemainder(x) * tenExp[mid2] + findRemainder(y)) % k;

    }
}
