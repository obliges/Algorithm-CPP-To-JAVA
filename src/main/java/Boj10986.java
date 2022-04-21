import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10986
public class Boj10986 {
    static int n, m;
    static long[] rest = new long[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            sum %= m;
            rest[sum]++;
        }
        Long count = 0L;
        count += rest[0];
        for (int i = 0; i < m; i++) {
            count += (rest[i] * (rest[i] - 1)) / 2;
        }
        bw.write(count.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
