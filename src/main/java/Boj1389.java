import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1389
public class Boj1389 {
    static int n;
    static int m;

    static int minimum = 999999999;

    static int minIndex = 9999;

    static int[][] relation = new int[101][101];
    static int[] bacon = new int[101];
    static int[] visit = new int[101];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> pool = new ArrayList<>();
            pool.add(i);
            bfs(i, 0, pool);
            bacon = new int[101];
            visit = new int[101];
        }
        System.out.println(minIndex);
    }

    private static void bfs(int start, int depth, ArrayList<Integer> pool) {
        if (pool.isEmpty()) {
            int sum = 0;
            for (int i = 1 ; i <= n; i++) {
                sum += bacon[i];
            }
            if (minimum == sum) {
                if (minIndex > start) {
                    minIndex = start;
                }
            }
            else if (minimum > sum) {
                minIndex = start;
                minimum = sum;
            }
            return;
        }
        ArrayList<Integer> newPool = new ArrayList<>();
        for (Integer i : pool) {
            visit[i] = 1;
            for (int j = 1; j <= n; j++) {
                if (relation[i][j] > 0 && visit[j] == 0) {
                    visit[j] = 1;
                    newPool.add(j);
                    bacon[j] = depth + 1;
                }
            }
        }
        bfs(start, depth + 1, newPool);
    }
}
