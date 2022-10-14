
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] A = new int[N];
        int[] cnt = new int[1_000_001];
        int[] F = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = stoi(st.nextToken());
            cnt[A[i]]++;
        }
        for (int i = 0; i < N; i++) {
            F[i] = cnt[A[i]];
        }
        int[] nge = new int[N];

        Deque<Integer> stk = new LinkedList<>();
        stk.push(0);
        for (int i = 1; i < N; i++) {
            int fi = F[i];
            int peek;
            while (!stk.isEmpty()) {
                peek = stk.peek();
                if (F[peek] < fi) {
                    nge[peek] = A[i] + 1;
                    stk.pop();
                } else
                    break;

            }
            stk.push(i);

        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            sb.append(nge[i] - 1).append(' ');

        System.out.println(sb.toString());
    }
}