
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    // Too slow!!

    // public static LinkedList<Integer> asc(int[] A, int N, int top) {
    // LinkedList<Integer> lis = new LinkedList<>();
    // int idx, item;
    // for (int i = 0; i <= top; i++) {
    // item = A[i];
    // idx = Collections.binarySearch(lis, item);
    // if (idx >= 0)
    // continue;
    // idx = -(idx + 1);
    // if (idx == lis.size())
    // lis.addLast(item);
    // else
    // lis.set(idx, item);
    // }

    // return lis;
    // }

    // public static LinkedList<Integer> desc(int[] A, int N, int top) {
    // LinkedList<Integer> lis = new LinkedList<>();
    // int idx, item;
    // for (int i = N - 1; top <= i; i--) {
    // item = A[i];
    // idx = Collections.binarySearch(lis, item);
    // if (idx >= 0)
    // continue;
    // idx = -(idx + 1);
    // if (idx == lis.size())
    // lis.addLast(item);
    // else
    // lis.set(idx, item);
    // }

    // return lis;
    // }

    // public static int lbsLen(LinkedList<Integer> l1, LinkedList<Integer> l2) {

    // int len1 = l1.size(), len2 = l2.size();
    // if (len1 == 0 || len2 == 0)
    // return Math.max(len1, len2);
    // int max1 = l1.getLast(), max2 = l2.getLast();

    // if (max1 == max2)
    // return len1 + len2 - 1;
    // else
    // return len1 + len2;

    // }

    // faster!
    static final int LEN = 0, TOP_VAL = 1;

    public static int[][] make_asc(int[] A, int N) {
        int[][] maxlens = new int[N][];

        LinkedList<Integer> lis = new LinkedList<>();
        int idx, item;
        for (int i = 0; i < N; i++) {
            item = A[i];
            idx = Collections.binarySearch(lis, item);
            if (idx < 0) {
                idx = -(idx + 1);
                if (idx == lis.size())
                    lis.add(item);
                else
                    lis.set(idx, item);
            }
            maxlens[i] = new int[] { lis.size(), lis.getLast() };
        }

        return maxlens;
    }

    public static int[][] make_desc(int[] A, int N) {
        int[][] maxlens = new int[N][];

        LinkedList<Integer> lis = new LinkedList<>();
        int idx, item;
        for (int i = N - 1; 0 <= i; i--) {
            item = A[i];
            idx = Collections.binarySearch(lis, item);
            if (idx < 0) {
                idx = -(idx + 1);
                if (idx == lis.size())
                    lis.add(item);
                else
                    lis.set(idx, item);
            }
            maxlens[i] = new int[] { lis.size(), lis.getLast() };
        }

        return maxlens;
    }

    public static int getMaxLen(int[][] l1, int[][] l2, int N) {

        int max = 1, len;
        for (int i = 0; i < N; i++) {
            len = l1[i][LEN] + l2[i][LEN];
            if (l1[i][TOP_VAL] == l2[i][TOP_VAL])
                len--;
            max = Math.max(max, len);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = stoi(st.nextToken());

        int maxlen = 1;
        // LinkedList<Integer> l1, l2;
        // for (int i = 0; i < N; i++) {
        // l1 = asc(A, N, i);
        // l2 = desc(A, N, i);
        // maxlen = Math.max(maxlen, lbsLen(l1, l2));
        // }

        int[][] l1 = make_asc(A, N);
        int[][] l2 = make_desc(A, N);
        maxlen = getMaxLen(l1, l2, N);
        System.out.println(maxlen);

    }
}