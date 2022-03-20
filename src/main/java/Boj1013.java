import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1013
public class Boj1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String pattern = "(100+1+|01)+";
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            if (s.matches(pattern)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }
}
