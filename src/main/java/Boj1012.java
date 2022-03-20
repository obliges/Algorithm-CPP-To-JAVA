import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1012
public class Boj1012 {
    public static int[][] b;
    public static int[][] v;
    public static int counter;
    public static int m;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            counter = 0;
            b = new int[50][50];
            v = new int[50][50];
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                b[x][y] = 1;
            }
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (b[j][l] == 0 || v[j][l] == 1) {
                        continue;
                    }
                    dfs(j, l);
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }

    public static void dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }
        if (b[r][c] == 0) {
            return;
        }
        if (v[r][c] == 1) {
            return;
        }
        v[r][c] = 1;

        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
        dfs(r + 1, c);
    }
}
