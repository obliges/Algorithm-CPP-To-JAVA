import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1011
public class Boj1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long d = y - x; // distance between x and y
            long index = -1;
            for (long j = 1; j < 100000; j++) {
                if (d <= j * (j + 1)) {
                    index = j;
                    break;
                }
            }
            if (d <= (index * (index + 1) + index * (index - 1)) / 2) {
                System.out.println(2 * index - 1);
            }
            else {
                System.out.println(2 * index);
            }
        }
    }
}
