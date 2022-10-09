
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void mergeSort(int[] A, int[] temp, int s, int e, boolean toTemp) {
        if (toTemp == false) {
            int[] x = A;
            A = temp;
            temp = x;
        }
        if (s == e) {
            temp[s] = A[s];
            return;
        } else if (s + 1 == e) {
            temp[s] = Math.min(A[s], A[e]);
            temp[e] = Math.max(A[s], A[e]);
            return;
        }
        mergeSort(A, temp, s, (s + e) / 2, !toTemp);
        mergeSort(A, temp, (s + e) / 2 + 1, e, !toTemp);

        int l = s, r = (s + e) / 2 + 1;
        int l_end = (s + e) / 2, r_end = e;
        int p = s;
        while ((l <= l_end) && (r <= r_end)) {
            if (A[l] <= A[r]) {
                temp[p++] = A[l++];
            } else {
                temp[p++] = A[r++];
            }
        }
        if (l > l_end) {
            l = r;
            l_end = r_end;
        }
        while (l <= l_end)
            temp[p++] = A[l++];

        // for (int i = s; i <= e; i++)
        // A[i] = temp[i];
    }

    public static int binarySearch(int[] A, int target, int s, int e) {
        if (s == e) {
            return A[s] == target ? 1 : 0;
        } else if (s + 1 == e) {
            return (A[s] == target || A[e] == target) ? 1 : 0;
        }
        int ret = binarySearch(A, target, s, (s + e) / 2);
        if (ret == 1)
            return 1;
        ret = binarySearch(A, target, (s + e) / 2 + 1, e);
        return ret;
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] A = new int[N], temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = stoi(st.nextToken());
            // temp[i] = A[i] = stoi(st.nextToken());

        }

        int M = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++)
            targets[i] = stoi(st.nextToken());
        // mergeSort(A, temp, 0, N - 1, true);
        Arrays.sort(A);
        // for (int x : A)
        // System.out.print(x);
        // System.out.println();

        StringBuilder sb = new StringBuilder(2 * M);

        for (int t : targets) {
            // sb.append(binarySearch(temp, t, 0, N - 1)).append('\n');
            sb.append(Arrays.binarySearch(A, t) >= 0 ? 1 : 0).append('\n');
        }
        System.out.println(sb.toString());

    }
}