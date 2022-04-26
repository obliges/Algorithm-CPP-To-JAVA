import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1654
public class Boj1654 {
    static long k, n;
    static long[] lan = new long[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Long.parseLong(st.nextToken());
        n = Long.parseLong(st.nextToken());
        long sum = 0;
        for (int i = 0; i < k; i++) {
            lan[i] = Long.parseLong(br.readLine());
            sum += lan[i];
        }
        System.out.println(findMax(1, sum / n));


    }

    private static long findMax(long start, long end) {
        if (start == end) {
            return start;
        }

        long temp = 0;
        long mid = (start + end) / 2;
        for (long i = 0; i < k; i++) {
            temp += lan[(int) i] / (mid + 1);
        }
        if (temp < n) {
            return findMax(start, mid);
        }
        return findMax(mid + 1, end);

    }
}
