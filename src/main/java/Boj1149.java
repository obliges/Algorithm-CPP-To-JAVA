import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

// https://www.acmicpc.net/problem/1149
public class Boj1149 {
    public static int n;
    public static int[][] info = new int[1000][3];
    public static int[][] dp = new int[1000][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            info[i][0] = a;
            info[i][1] = b;
            info[i][2] = c;
        }
        System.out.println(min(min(findMin(0, 0), findMin(0, 1)), findMin(0, 2)));
    }

    private static int findMin(int cur, int mask) {
        if (dp[cur][mask] != 0) {
            return dp[cur][mask];
        }
        if (cur == n - 1) {
            return dp[n-1][mask] = info[n-1][mask];
        }
        int temp1 = 99999999, temp2 = 99999999, temp3 = 99999999;
        if (mask != 0) {
            temp1 = findMin(cur + 1, 0);
        }
        if (mask != 1) {
            temp2 = findMin(cur + 1, 1);
        }
        if (mask != 2) {
            temp3 = findMin(cur + 1, 2);
        }

        return dp[cur][mask] = info[cur][mask] + min(min(temp1, temp2), temp3);
    }
}
