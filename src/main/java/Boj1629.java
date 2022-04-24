import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1629
public class Boj1629 {
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(power(a, b));
    }

    private static long power(long a, long b) {
        if (b == 0) {
            return 1 % c;
        }
        if (b == 1) {
            return a % c;
        }
        long temp = (power(a, b / 2) % c);
        if (b % 2 == 0) {
            return (temp * temp) % c;
        }
        return ((temp * temp) % c * a) % c;
    }
}
