
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static int[] A;

    static int merge_sort(int[] A, int[] temp, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            int ret;
            ret = merge_sort(A, temp, p, q);
            if (ret > 0)
                return ret;
            ret = merge_sort(A, temp, q + 1, r);
            if (ret > 0)
                return ret;
            ret = merge(A, temp, p, q, r);
            return ret;
        }

        return -1;
    }

    static int merge(int[] A, int[] temp, int p, int q, int r) {
        int i = p, j = q + 1, t = p;
        while (i <= q && j <= r) {
            if (A[i] <= A[j])
                temp[t++] = A[i++];
            else
                temp[t++] = A[j++];
        }
        while (i <= q)
            temp[t++] = A[i++];
        while (j <= r)
            temp[t++] = A[j++];

        for (i = p; i <= r; i++) {
            A[i] = temp[i];
            if (--K == 0) {
                return A[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        A = new int[N];
        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = stoi(st.nextToken());
        int ret = merge_sort(A, temp, 0, N - 1);
        System.out.println(ret);
    }
}