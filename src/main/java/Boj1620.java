import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1620
public class Boj1620 {

    static int n, m;
    static Map<String, String> book = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (Integer i = 1; i <= n; i++) {
            String name = br.readLine();
            book.put(i.toString(), name);
            book.put(name, i.toString());

        }
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            System.out.println(book.get(question));
        }
    }
}
