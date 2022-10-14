
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int MEM = 0, COST = 1, MAX_COST = 10001;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int memdp(int[][] apps, int N, int M) {
        int[] dpi = new int[M + 1], dpi_1 = new int[M + 1], temp;
        Arrays.fill(dpi, MAX_COST);
        Arrays.fill(dpi_1, MAX_COST);
        dpi[0] = dpi_1[0] = 0;
        for (int i = 0; i < N; i++) {
            int mem = apps[i][MEM], cost = apps[i][COST];

            for (int m = 1; m <= M; m++) {
                dpi[m] = Math.min(dpi_1[m], (mem <= m ? dpi_1[m - mem] : 0) + cost);
            }
            // swap;
            temp = dpi;
            dpi = dpi_1;
            dpi_1 = temp;
        }
        return dpi_1[M];
    }

    static int costdp(int[][] apps, int N, int M) {
        int[] dpi = new int[MAX_COST], dpi_1 = new int[MAX_COST], temp;

        for (int[] app : apps) {
            int mem = app[MEM], cost = app[COST];

            for (int c = 0; c < MAX_COST; c++) {
                dpi[c] = Math.max(dpi_1[c], 0 <= c - cost ? (dpi_1[c - cost] + mem) : 0);
            }
            // swap
            temp = dpi;
            dpi = dpi_1;
            dpi_1 = temp;
        }
        for (int c = 0; c < MAX_COST; c++)
            if (M <= dpi_1[c])
                return c;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        int[][] apps = new int[N][2];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apps[i][MEM] = stoi(st.nextToken());
            apps[i][COST] = stoi(st2.nextToken());
        }
        int ret;
        // ret = memdp(apps, N, M);
        ret = costdp(apps, N, M);
        System.out.println(ret);
    }
}
