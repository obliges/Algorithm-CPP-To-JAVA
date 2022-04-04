import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

// https://www.acmicpc.net/problem/1181
public class Boj1181 {
    static int n;
    static ArrayList<String> l = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            l.add(br.readLine());
        }
        Collections.sort(l, new StringComparator());
        String prev = "";
        for (String s : l) {
            if (!prev.equals(s)) {
                System.out.println(s);
            }
            prev = s;
        }
    }

    static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            }
            else if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            else {
                return -1;
            }
        }
    }
}
