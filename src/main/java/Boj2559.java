import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2559
public class Boj2559 {
    static int[] arr = new int[100001];
    static int[] sum = new int[100001];
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = i == 0 ? arr[i] : sum[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            max = Math.max(max, sum[i + k] - sum[i]);
        }
        System.out.println(max);

    }
}
