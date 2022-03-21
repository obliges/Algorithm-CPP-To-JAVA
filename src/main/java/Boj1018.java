import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1018
public class Boj1018 {
    public static int[][] b = new int[50][50];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'B') {
                    b[i][j] = 0;
                } else {
                    b[i][j] = 1;
                }
            }
        }
        int output = 1000;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int temp = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if ((k + l) % 2 == 0) {
                            if (b[i+k][j+l] == 0) {
                                temp++;
                            }
                        }
                        else {
                            if (b[i+k][j+l] == 1) {
                                temp++;
                            }
                        }
                    }
                }
                output = Math.min(Math.min(temp, 64 - temp), output);
            }
        }
        System.out.println(output);


    }
}
