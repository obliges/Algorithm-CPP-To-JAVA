import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/1541
public class Boj1541 {
    static String s;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        char[] expr = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (char c : expr) {
            if (c == '+' || c == '-') {
                op.add(c);
                num.add(Integer.parseInt(temp.toString()));
                temp = new StringBuilder();
            }
            else {
                temp.append(c);
            }
        }
        num.add(Integer.parseInt(temp.toString()));
        if (op.size() == 0) {
            System.out.println(num.get(0));
            return;
        }
        Boolean isMinus = false;
        for (int i = 0; i < op.size(); i++) {
            Character cur = op.get(i);
            if (cur == '+') {
                if (isMinus) {
                    op.remove(i);
                    op.add(i, '-');
                    continue;
                }
            } else {
                isMinus = true;
            }
        }

        int output = num.get(0);
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i) == '+') {
                output += num.get(i + 1);
            } else {
                output -= num.get(i + 1);
            }
        }
        System.out.println(output);
    }
}
