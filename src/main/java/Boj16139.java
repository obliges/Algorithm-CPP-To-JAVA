import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16139
public class Boj16139 {
    static String s;
    static int q;
    static int[][] info = new int[200001][26];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();
        q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= 25; j++) {
                info[i][j] = info[i-1][j];
            }
            int cur = s.charAt(i - 1) - 'a';
            info[i][cur]++;
        }
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alpha = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(info[end + 1][alpha] - info[start][alpha] + "\n");
        }
        bw.close();


    }
}
