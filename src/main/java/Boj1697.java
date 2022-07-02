import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1697
public class Boj1697 {
    static int n, k;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        recursion(List.of(n), 0);
    }

    private static void recursion(List<Integer> list, int depth) {
        List<Integer> nextList = new ArrayList<>();
        for (Integer i : list) {
            if (i.equals(k)) {
                System.out.println(depth);
                return;
            }
            visit[i] = 1;
            if (i - 1 >= 0 && visit[i - 1] == 0) {
                visit[i - 1] = 1;
                nextList.add(i - 1);
            }
            if (i + 1 <= 100000 && visit[i + 1] == 0) {
                visit[i + 1] = 1;
                nextList.add(i + 1);
            }
            if (i * 2 <= 100000 && visit[i * 2] == 0) {
                visit[i * 2] = 1;
                nextList.add(i * 2);
            }
        }
        recursion(nextList, depth + 1);
    }
}
