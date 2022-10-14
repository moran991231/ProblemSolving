
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = stoi(st.nextToken());
        int[] nge = new int[N];

        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (int i = 1; i < N; i++) {
            int ai = A[i];
            int peek;
            while (!stk.isEmpty()) {
                peek = stk.peek();
                if (A[peek] < ai) {
                    nge[peek] = ai + 1;
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