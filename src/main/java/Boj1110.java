import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1110
public class Boj1110 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(cycle(n, 0));
    }

    private static int cycle(int k, int depth) {

        int nextNum = (k / 10 + k % 10) % 10 + (k % 10) * 10;
        if (nextNum == n) {
            return depth + 1;
        }

        return cycle(nextNum, depth + 1);
    }
}
