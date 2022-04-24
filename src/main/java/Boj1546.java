import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1546
public class Boj1546 {
    static int n;
    static double sum = 0;
    static double max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            double cur = Double.parseDouble(st.nextToken());
            sum += cur;
            max = Math.max(cur, max);
        }
        System.out.printf("%.10f", sum / max / n * 100);


    }
}
