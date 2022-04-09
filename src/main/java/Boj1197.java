import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

// https://www.acmicpc.net/problem/1197
public class Boj1197 {
    static int v;
    static int e;
    static ArrayList<ArrayList<Edge>> a = new ArrayList<>();
    static int[] visit = new int[10001];
    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    static class Edge implements Comparable<Edge> {
        int cost;
        int to;

        public Edge(int cost, int to) {
            this.cost =cost;
            this.to =to;
        }

        public int getCost() {
            return cost;
        }

        public int getTo() {
            return to;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.getCost(), o.getCost());
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = parseInt(st.nextToken());
        e = parseInt(st.nextToken());
        for (int i = 0; i <= e + 1; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x, y, z;
            x = parseInt(st.nextToken());
            y = parseInt(st.nextToken());
            z = parseInt(st.nextToken());
            a.get(x).add(new Edge(z, y));
            a.get(y).add(new Edge(z, x));
        }
        int output = 0;
        int numEdge = 0;
        visit[1]++;
        for (Edge edge : a.get(1)) {
            queue.add(edge);
        }
        while (!queue.isEmpty() && numEdge != v - 1) {
            Edge next = null;
            while (!queue.isEmpty()) {
                next = queue.poll();
                if (visit[next.getTo()] == 0) {
                    break;
                }
            }
            output += next.getCost();
            visit[next.getTo()]++;
            for (Edge edge : a.get(next.getTo())) {
                queue.add(edge);
            }
            numEdge++;
        }
        System.out.println(output);

    }
}
