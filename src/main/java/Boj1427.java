import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/1427
public class Boj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] chars = s.toCharArray();
        ArrayList<Integer> sList = new ArrayList<>();
        for (char c : chars) {
            sList.add(c - '0');
        }
        Collections.sort(sList);
        Collections.reverse(sList);
        for (Integer integer : sList) {
            System.out.print(integer);
        }
    }
}
