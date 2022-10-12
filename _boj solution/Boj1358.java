
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static boolean isInSquare(int X, int Y, int W, int H, int[] p) {
        return (X <= p[0] && p[0] <= X + W && Y <= p[1] && p[1] <= Y + H);
    }

    public static int distance(int cx, int cy, int[] p) {
        return (cx - p[0]) * (cx - p[0]) + (cy - p[1]) * (cy - p[1]);
    }

    public static boolean isInCircle(int X, int Y, int R, int W, int[] p) {
        int d1 = distance(X, Y + R, p);
        int d2 = distance(X + W, Y + R, p);
        return (d1 <= R * R) || (d2 <= R * R);
    }

    public static boolean inLink(int X, int Y, int W, int H, int[] p) {
        if (isInSquare(X, Y, W, H, p))
            return true;
        return isInCircle(X, Y, H / 2, W, p);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int W = stoi(st.nextToken()), H = stoi(st.nextToken());
        int X = stoi(st.nextToken()), Y = stoi(st.nextToken());
        int P = stoi(st.nextToken());

        int[] player = new int[2];
        int cnt = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            player[0] = stoi(st.nextToken());
            player[1] = stoi(st.nextToken());
            if (inLink(X, Y, W, H, player))
                cnt++;
        }
        System.out.println(cnt);

    }
}