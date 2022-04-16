import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1450
public class Boj1450 {
    static int n;
    static int c;
    static ArrayList<Integer> v1 = new ArrayList<>();
    static ArrayList<Integer> v2 = new ArrayList<>();

    static int[] weight = new int[30];

    static void fill(ArrayList<Integer> v, int sum, int start, int end) {
        if (sum > c) {
            return;
        }
        if (start > end) {
            v.add(sum);
            return;
        }
        fill(v, sum, start + 1, end);
        fill(v, sum + weight[start], start + 1, end);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        fill(v1, 0, 0, (n - 1) / 2);
        fill(v2, 0, (n - 1) / 2 + 1, n - 1);
        v2.sort(Integer::compareTo);
        int sum = 0;
        for (Integer i : v1) {
            sum += findUpperBound(0, v2.size() - 1, c - i);
        }
        System.out.println(sum);
    }

    private static int findUpperBound(int start, int end, int threshold) {
        int pos;

        if (start == end) {
            if (start == v2.size() - 1 && v2.get(start) <= threshold) {
                return v2.size();
            }
            return start;
        }

        int mid = (start + end) / 2;

        if (v2.get(mid) <= threshold) {
            pos = findUpperBound(mid + 1, end, threshold);
        } else {
            pos = findUpperBound(start, mid, threshold);
        }

        return pos;
    }
}
