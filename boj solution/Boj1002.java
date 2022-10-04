
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int cntRyu(String s) {
        int x1, y1, r1, x2, y2, r2;
        st = new StringTokenizer(s);
        x1 = stoi(st.nextToken());
        y1 = stoi(st.nextToken());
        r1 = stoi(st.nextToken());
        x2 = stoi(st.nextToken());
        y2 = stoi(st.nextToken());
        r2 = stoi(st.nextToken());
        int maxr = Math.max(r1, r2), minr = Math.min(r1, r2);

        int d2 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        int rr = (r1 + r2) * (r1 + r2);
        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;

        if (d2 > rr)
            return 0;
        else if (d2 == rr)
            return 1;
        else {

            if (d2 < maxr * maxr) {
                int diffr = (maxr - minr) * (maxr - minr);
                if (diffr == d2)
                    return 1;
                else if (d2 < diffr)
                    return 0;
                else
                    return 2;
            }
            return 2;

        }

    }

    public static void main(String[] args) throws IOException {
        int T = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(cntRyu(br.readLine())).append('\n');

        }
        System.out.println(sb.toString());
    }
}
