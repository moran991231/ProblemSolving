
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
        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wires[i][0] = stoi(st.nextToken());
            wires[i][1] = stoi(st.nextToken());
        }
        Arrays.sort(wires, (a, b) -> a[0] - b[0]);

        LinkedList<Integer> lis = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int item = wires[i][1];
            int idx = Collections.binarySearch(lis, item);
            if (idx < 0) {
                idx = -(idx + 1);
                if (idx == lis.size())
                    lis.add(item);
                else
                    lis.set(idx, item);
            }
        }

        System.out.println(N - lis.size());
    }
}