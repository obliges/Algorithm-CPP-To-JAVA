import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1436
public class Boj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int order = 0;
        int output = 0;
        for (Integer i = 666; i < 2100000000; i++) {
            String temp = i.toString();
            int count = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '6') {
                    count++;
                }
                else {
                    count = 0;
                }
                if (count >= 3) {
                    order++;
                    break;
                }
            }
            if (order == n) {
                output = i;
                break;
            }
        }
        System.out.println(output);
    }
}
