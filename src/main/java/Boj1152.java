import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1152
public class Boj1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int counter = 0;

        while(st.hasMoreTokens()) {
            st.nextToken();
            counter++;
        }
        System.out.println(counter);
    }
}
