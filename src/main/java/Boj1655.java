import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1655
public class Boj1655 {
    static int n;
    static PriorityQueue<Integer> minq = new PriorityQueue<>(Integer::compareTo);
    static PriorityQueue<Integer> maxq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                minq.add(k);
                maxq.add(minq.poll());
            }
            else {
                maxq.add(k);
                minq.add(maxq.poll());
            }
            bw.write(maxq.peek() + "\n");
        }
        bw.close();

    }
}
