import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

// https://www.acmicpc.net/problem/1010
public class Boj1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());

        int[][] pascal= new int[31][31];

        for (int i = 0; i <= 30; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
        }

        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
            }
        }

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            System.out.println(pascal[m][n]);
        }
    }
}
