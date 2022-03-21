import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1016
public class Boj1016 {
    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long minimum = Long.parseLong(st.nextToken());
        long maximum = Long.parseLong(st.nextToken());

        for (long i = 2; i * i <= maximum; i++) {
            for (long j = minimum / (i * i); j*i*i <= maximum; j++) {
                if (i*i*j >= minimum && i*i*j <= maximum) {
                    dp[(int) (i*i*j - minimum)]++;
                }
            }
        }
        int counter = 0;
        for (long i = minimum; i <= maximum; i++) {
            if (dp[(int) (i - minimum)] == 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
