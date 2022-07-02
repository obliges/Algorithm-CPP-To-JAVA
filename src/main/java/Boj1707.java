import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1707
public class Boj1707 {
    static int k, v, e;
    static ArrayList<ArrayList<Integer>> a;
    static int[] visit;
    static boolean isBipartite = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            a = new ArrayList<>();
            isBipartite = true;
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= 20000; j++) {
                a.add(new ArrayList<>());
            }
            visit = new int[20001];
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int temp1 = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());
                a.get(temp1).add(temp2);
                a.get(temp2).add(temp1);
            }
            for (int j = 1; j <= v; j++) {
                if (!isBipartite) {
                    break;
                }
                if (visit[j] == 0) {
                    List<Integer> p = new ArrayList<>();
                    p.add(j);
                    visit[j] = 2;
                    doBFS(p, 1);
                }
            }
            if (isBipartite) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }


    }

    private static void doBFS(List<Integer> p, int color) {
        List<Integer> temp = new ArrayList<>();
        for (Integer i : p) {
            for (Integer j : a.get(i)) {
                if (visit[j] == color) {
                    continue;
                }
                else if (visit[j] == 0) {
                    visit[j] = color;
                    temp.add(j);
                }
                else {
                    isBipartite = false;
                }
            }
        }
        if (temp.isEmpty()) {
            return;
        }
        if (color == 1) {
            doBFS(temp, 2);
        }
        else {
            doBFS(temp, 1);
        }

    }
}
