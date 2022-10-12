
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
        int min = 1_000_000, max = 1, temp;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp = stoi(st.nextToken());
            if (temp < min)
                min = temp;
            if (max < temp)
                max = temp;
        }
        System.out.println(min * max);

    }
}