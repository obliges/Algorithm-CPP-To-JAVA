import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/1003
public class Boj1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        List<Integer> fibo = new ArrayList<>();
        fibo.add(1);
        fibo.add(1);

        for (int i = 2; i < 41; i++) {
            fibo.add(fibo.get(i - 1) + fibo.get(i - 2));
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println(1 + " " + 0);
            }
            else if (n == 1) {
                System.out.println(0 + " " + 1);
            }
            else {
                System.out.println(fibo.get(n - 2) + " " + fibo.get(n - 1));
            }
        }
    }
}
