import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1065
public class Boj1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (isHanNumber(Integer.toString(i))) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static boolean isHanNumber(String s) {
        boolean returnvalue = true;
        int diff = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (i == 0) {
                diff = s.charAt(i) - s.charAt(i + 1);
            }
            else {
                if (diff != s.charAt(i) - s.charAt(i + 1)) {
                    returnvalue = false;
                    break;
                }
            }

        }
        return returnvalue;
    }
}
