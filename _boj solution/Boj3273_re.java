
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int bsearch(int[] A, int target) {
        int l = 0, r = A.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (A[m] == target)
                return m;
            else if (A[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = stoi(st.nextToken());
        int X = stoi(br.readLine());

        Arrays.sort(A);
        int cnt = 0, j;
        for (int i = 0; i < N; i++) {
            if (X / 2 < A[i])
                break;
            // j = Arrays.binarySearch(A, X - A[i]);
            j = bsearch(A, X - A[i]);
            if (j > i)
                cnt++;
        }
        System.out.println(cnt);
    }
}