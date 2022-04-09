import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://www.acmicpc.net/problem/1259
public class Boj1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while(!s.equals("0")) {
            ArrayList<Integer> cur = new ArrayList<>();
            ArrayList<Integer> reverse = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                cur.add((int) s.charAt(i));
                reverse.add((int) s.charAt(s.length() - 1 - i));
            }
            if (cur.equals(reverse)) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
            s = br.readLine();
        }
    }
}
