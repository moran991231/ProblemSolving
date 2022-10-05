
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static int lisLen(int[] A, int N) {
        LinkedList<Integer> lis = new LinkedList<>();
        lis.add(A[0]);
        int idx;
        for (int i = 1; i < N; i++) {
            idx = Collections.binarySearch(lis, A[i]);
            if (idx >= 0)
                continue;
            idx = -(idx + 1);
            if (idx == lis.size())
                lis.add(idx, A[i]);
            else
                lis.set(idx, A[i]);

        }
        return lis.size();
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = stoi(st.nextToken());

        int len = lisLen(A, N);
        System.out.println(len);

    }
}