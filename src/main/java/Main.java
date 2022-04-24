import java.io.*;
import java.util.*;



public class Main {

    static int n;
    static int[] prime = new int[4000001];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= 2000; i++) {
            if (prime[i] == 0) {
                for (int j = 2; j * i <= 4000000; j++) {
                    prime[j * i] = 1;
                }
            }
        }
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= 4000000; i++) {
            if (prime[i] != 0) {
                continue;
            }
            q.add(i);
            sum += i;
            if (sum < n) {
                continue;
            }
            while (sum - q.peek() >= n) {
                sum -= q.poll();
            }
            if (sum == n) {
                count++;
            }
            if (i == sum) {
                break;
            }
        }
        System.out.println(count);


    }



}

