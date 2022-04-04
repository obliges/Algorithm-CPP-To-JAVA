import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

// https://www.acmicpc.net/problem/1167
public class Boj1167 {
    static int v;
    static ArrayList<ArrayList<Edge>> a = new ArrayList<>();
    static int[] visit = new int[100001];
    static int maximum = -1;
    static int maxindex = -1;

    static class Edge {
        int dest;
        int dist;

        public Edge(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }

        public int getDest() {
            return dest;
        }

        public int getDist() {
            return dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = parseInt(br.readLine());
        for (int i = 0; i <= v + 1; i++) {
            a.add(new ArrayList<>());
        }


        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            while (y != - 1) {
                int z = parseInt(st.nextToken());
                a.get(x).add(new Edge(y, z));
                y = parseInt(st.nextToken());
            }
        }
        dfs(1, 0);
        clear();
        dfs(maxindex, 0);
        System.out.println(maximum);

    }

    private static void clear() {
        visit = new int[100001];
    }

    private static void dfs(int k, int sum) {
        boolean isLast = true;
        visit[k] = 1;
        for (Edge edge : a.get(k)) {
            int dest = edge.getDest();
            int dist = edge.getDist();
            if (visit[dest] == 0) {
                dfs(dest, sum + dist);
                isLast = false;
            }
        }
        if (isLast) {
            if (sum >= maximum) {
                maximum = sum;
                maxindex = k;
            }
        }
    }
}
