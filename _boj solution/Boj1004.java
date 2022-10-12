
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final int X = 0, Y = 1, R = 2;

    public static int distance(int[] p, int x, int y) {
        return (x - p[X]) * (x - p[X]) + (y - p[Y]) * (y - p[Y]);
    }

    public static Set<Integer> cntSystem(int[][] planetes, int x, int y) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < planetes.length; i++) {
            int[] p = planetes[i];
            int d = distance(p, x, y);
            if (d < p[R] * p[R]) {
                s.add(i);
            }
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken()), y1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken()), y2 = stoi(st.nextToken());

            int N = stoi(br.readLine());
            int[][] planetes = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                planetes[i][X] = stoi(st.nextToken());
                planetes[i][Y] = stoi(st.nextToken());
                planetes[i][R] = stoi(st.nextToken());

            }
            Set<Integer> prince = cntSystem(planetes, x1, y1);
            Set<Integer> rose = cntSystem(planetes, x2, y2);

            int cnt = 0;
            for (int i : prince)
                if (!rose.contains(i))
                    cnt++;

            for (int i : rose)
                if (!prince.contains(i))
                    cnt++;
            sb.append(cnt).append('\n');

        }
        System.out.println(sb.toString());
    }
}