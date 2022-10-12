
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = stoi(st.nextToken()), y = stoi(st.nextToken());
        int w = stoi(st.nextToken()), h = stoi(st.nextToken());
        int min = w;
        min = Math.min(min, x);
        min = Math.min(min, y);
        min = Math.min(min, w - x);
        min = Math.min(min, h - y);
        System.out.println(min);

    }
}