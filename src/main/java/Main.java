import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String pattern = "(100+1+|01)+";
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            if (s.matches(pattern)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
