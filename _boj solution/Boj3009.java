
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int findLast(int[] a) {
        if (a[0] != a[1])
            return a[0];
        else
            return a[2];
    }

    public static void main(String[] args) throws IOException {
        int[] x = new int[3], y = new int[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = stoi(st.nextToken());
            y[i] = stoi(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);
        System.out.printf("%d %d \n", findLast(x), findLast(y));

    }
}