import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1026
public class Boj1026 {
    public static Integer [] a = new Integer[100];
    public static Integer [] b = new Integer[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, 0, n);
        Arrays.sort(b, 0, n, Collections.reverseOrder());

        int output = 0;
        for (int i = 0; i < n; i++) {
            output += a[i] * b[i];
        }
        System.out.println(output);
    }
}
