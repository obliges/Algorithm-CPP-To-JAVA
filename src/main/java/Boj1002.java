import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1002
public class Boj1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            double x1, y1, r1, x2, y2, r2;
            x1 = Double.parseDouble(input[0]);
            y1 = Double.parseDouble(input[1]);
            r1 = Double.parseDouble(input[2]);
            x2 = Double.parseDouble(input[3]);
            y2 = Double.parseDouble(input[4]);
            r2 = Double.parseDouble(input[5]);
            double dist = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            if (dist > r1 + r2) {
                System.out.println(0);
            }
            else if (dist == r1 + r2) {
                System.out.println(1);
            }
            else if (dist > Math.abs(r1 - r2)) {
                System.out.println(2);
            }
            else if (dist == Math.abs(r1 - r2)) {
                if (r1 == r2) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(1);
                }
            }
            else {
                System.out.println(0);
            }
        }
    }
}
