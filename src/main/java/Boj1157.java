import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1157
public class Boj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toUpperCase();
        int[] num = new int[26];

        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'A']++;
        }

        int max = -1;
        int index = -1;
        boolean overrapped = false;
        for (int i = 0; i < 26; i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
                overrapped = false;
            }
            else if (num[i] == max) {
                overrapped = true;
            }
        }
        if (overrapped) {
            System.out.println("?");
        }
        else {
            System.out.println((char) ('A' + index));
        }

    }
}
