import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1562
public class Boj1562 {

    static int n;
    static int[][][] dp = new int[101][10][1024];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }
        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 1023; k++) {
                    if (j != 0) {
                        dp[i][j - 1][k | (1 << (j - 1))] += dp[i - 1][j][k] % 1000000000;
                        dp[i][j - 1][k | (1 << (j - 1))] %= 1000000000;
                    }
                    if (j != 9) {
                        dp[i][j + 1][k | (1 << (j + 1))] += dp[i - 1][j][k] % 1000000000;
                        dp[i][j + 1][k | (1 << (j + 1))] %= 1000000000;
                    }
                }
            }
        }
        int output = 0;
        for (int i = 0; i <= 9; i++) {
            output += dp[n][i][1023] % 1000000000;
            output %= 1000000000;
        }
        System.out.println(output);
    }
}
