import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1316
public class Boj1316 {
    static int n;

    static int[] check = new int[26];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int counter = n;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int prev = -1;
            for (int j = 0; j < word.length(); j++) {
                int cur = word.charAt(j) - 'a';
                if (prev == cur) {
                    check[cur]++;
                    prev = cur;
                }
                else {
                    if (check[cur] == 0) {
                        check[cur]++;
                        prev = cur;
                    }
                    else {
                        counter--;
                        break;
                    }
                }
            }
            check = new int[26];
        }


        System.out.println(counter);


    }
}
