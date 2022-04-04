import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

// https://www.acmicpc.net/problem/1193
public class Boj1193 {
    static int n;
    static int a = 1;
    static int b = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        if (n == 1) {
            System.out.println(a + "/" + b);
            return;
        }
        int index = 0;
        for (int i = 2; i < 10000000; i++) {
            if (n <= i * (i + 1) / 2) {
                index = i;
                break;
            }
        }
        int temp = n - index*(index - 1) / 2;
        int d = index * (index + 1) / 2 - index * (index - 1) / 2;
        if (index % 2 == 0) {
            a = temp;
            b = d - temp + 1;
        }
        else {
            b = temp;
            a = d - temp + 1;
        }
        System.out.println(a + "/" + b);



    }
}
