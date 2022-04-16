import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1463
public class Boj1463 {
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            int m = 99999999;
            if (i % 3 == 0) {
                m = Math.min(m, 1 + dp[i / 3]);
            }
            if (i % 2 == 0) {
                m = Math.min(m, 1 + dp[i / 2]);
            }
            m = Math.min(m, 1 + dp[i - 1]);
            dp[i] = m;
        }

        System.out.println(dp[n]);

    }
}
