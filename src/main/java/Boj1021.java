import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1021
public class Boj1021 {
    public static int[] order = new int[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> d = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            d.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int counter = 0;
        for (int i = 0; i < m; i++) {
            int leftcount = 0;
            while (d.getFirst() != order[i]) {
                int temp = d.getFirst();
                d.removeFirst();
                d.addLast(temp);
                leftcount++;
            }
            counter += Math.min(leftcount, d.size() - leftcount);
            d.removeFirst();
        }
        System.out.println(counter);
    }
}
