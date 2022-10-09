
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static int euclidean(int a, int b) {
        if (a < b)
            return euclidean(b, a);
        int r = a % b;
        if (r == 0)
            return b;
        return euclidean(b, r);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(10);
        int N = stoi(br.readLine());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = stoi(br.readLine());
        }

        int gcd = Math.abs(nums[0] - nums[1]);
        for (int i = 1; i < N - 1; i++) {
            gcd = euclidean(Math.abs(nums[i] - nums[i + 1]), gcd);
        }

        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0)
                sb.append(i).append(' ');

        }

        System.out.println(sb.toString());

    }
}