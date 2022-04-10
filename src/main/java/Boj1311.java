import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1311
public class Boj1311 {
    static int n;

    static int[][] d = new int[20][20];
    static int[][] dp = new int[20][1 << 20];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(findMin(0, 0));


    }

    private static int findMin(int cur, int mask) {
        if (cur == n) {
            return 0;
        }
        if (dp[cur][mask] != 0) {
            return dp[cur][mask];
        }
        int minimum = 999999999;
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) != 1) {
                minimum = Math.min(minimum, d[cur][i] + findMin(cur + 1, mask | (1 << i)));
            }
        }
        return dp[cur][mask] = minimum;

    }
}
