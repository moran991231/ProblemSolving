
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int circulate(int[] A, int N) {
        int cnt = 0, temp_cnt = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            dq.add(i);
        for (int target : A) {
            for (temp_cnt = 0; dq.getFirst() != target; temp_cnt++)
                dq.add(dq.removeFirst());
            cnt += Math.min(temp_cnt, dq.size() - temp_cnt);
            dq.removeFirst();
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        int[] A = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            A[i] = stoi(st.nextToken());

        int ret = circulate(A, N);
        System.out.println(ret);
    }
}