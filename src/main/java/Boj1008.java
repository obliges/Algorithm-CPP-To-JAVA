import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1008
public class Boj1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");
        double a = Double.parseDouble(ab[0]);
        double b = Double.parseDouble(ab[1]);

        System.out.printf("%.15f", a / b);
    }
}
