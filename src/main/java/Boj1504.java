import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1504
public class Boj1504 {
    static int n;
    static int e;
    static int v1;
    static int v2;
    static ArrayList<ArrayList<int[]>> edge = new ArrayList<>();
    static int[][] dist = new int[3][801];

    static class NodeInfo implements Comparable<NodeInfo> {
        int cost;
        int pos;

        int get(int k) {
            return k == 0 ? cost : pos;
        }


        @Override
        public int compareTo(NodeInfo o) {
            return this.cost - o.cost;
        }

        public NodeInfo(int cost, int pos) {
            this.cost = cost;
            this.pos = pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n + 1; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] temp1 = {b, c};
            int[] temp2 = {a, c};
            edge.get(a).add(temp1);
            edge.get(b).add(temp2);

        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            dist[0][i] = 87654321;
            dist[1][i] = 87654321;
            dist[2][i] = 87654321;
        }
        dist[0][1] = 0;
        dist[1][v1] = 0;
        dist[2][v2] = 0;
        for (int i = 0; i < 3; i++) {
            int k = 0;
            PriorityQueue<NodeInfo> q = new PriorityQueue<>();
            switch (i) {
                case 0:
                    k = 1;
                    break;
                case 1:
                    k = v1;
                    break;
                case 2:
                    k = v2;
                    break;
            }
            NodeInfo temp = new NodeInfo(dist[i][k], k);
            q.add(temp);
            while (!q.isEmpty()) {
                NodeInfo current = q.poll();
                int pos = current.get(1);
                int cost = current.get(0);
                for (int[] ints : edge.get(pos)) {
                    int dest = ints[0];
                    int destCost = ints[1];
                    if (dist[i][dest] > cost + destCost) {
                        dist[i][dest] = cost + destCost;
                        NodeInfo put = new NodeInfo(dist[i][dest], dest);
                        q.add(put);
                    }
                }
            }
        }
        int output = Math.min(dist[0][v1] + dist[1][v2] + dist[2][n], dist[0][v2] + dist[2][v1] + dist[1][n]);
        if (output >= 87654321) {
            System.out.println(-1);
            return;
        }
        System.out.println(output);
    }
}
