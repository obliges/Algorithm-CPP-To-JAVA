import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1260
public class Boj1260 {
    static int n;
    static int m;
    static int v;
    static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
    static int[] visitDfs = new int[1001];
    static int[] visitBfs = new int[1001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n + 1; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge.get(a).add(b);
            edge.get(b).add(a);
        }
        dfs(v);
        System.out.println();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(v);
        bfs(temp);
    }

    public static void dfs(int k) {
        visitDfs[k]++;
        System.out.print(k + " ");

        edge.get(k).sort(Integer::compareTo);
        edge.get(k).stream().forEach(t -> {
            if (visitDfs[t] == 0) {
                dfs(t);
                visitDfs[t]++;
            }
        });
    }

    public static void bfs(ArrayList<Integer> k) {
        if (k.isEmpty()) {
            return;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        k.stream().forEach(t -> {
            visitBfs[t]++;
            System.out.print(t + " ");
            edge.get(t).sort(Integer::compareTo);
            edge.get(t).stream().forEach(s -> {
                if (visitBfs[s] == 0) {
                    temp.add(s);
                    visitBfs[s]++;
                }
            });
        });
        if (!temp.isEmpty()) {
            bfs(temp);
        }
    }
}
