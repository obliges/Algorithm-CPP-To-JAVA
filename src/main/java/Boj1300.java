import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1300
public class Boj1300 {

    static long n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        long output = findMin(1, n * n);
        System.out.println(output);

    }

    private static long findMin(long start, long finish) {
        if (start == finish) {
            return start;
        }
        long mid = (start + finish) / 2;
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += Math.min(n, mid / i);
        }
        if (sum >= k) {
            return findMin(start, mid);
        } else {
            return findMin(mid + 1, finish);
        }
    }
}
