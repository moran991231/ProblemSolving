
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean[] makedp(int[] chu, int num_chu) {
        boolean[] dpi_1 = new boolean[15001], dpi = new boolean[15001], temp;
        dpi_1[0] = dpi[0] = true;
        for (int i = 0; i < num_chu; i++) {
            int chui = chu[i];

            for (int w = 1; w <= 15000; w++) {
                dpi[w] = dpi_1[w] || (0 <= (w - chui) ? dpi_1[w - chui] : false);
            }
            // swap
            temp = dpi;
            dpi = dpi_1;
            dpi_1 = temp;
        }
        return dpi_1;

    }

    static boolean isCheckable(boolean[] dp, int m) {
        if (m > 15000)
            return false;

        for (int x = 0; m + x <= 15000; x++) {
            if (dp[x] && dp[m + x])
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        int num_chu = stoi(br.readLine());
        int[] chu = new int[num_chu];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_chu; i++)
            chu[i] = stoi(st.nextToken());

        int num_marble = stoi(br.readLine());
        int[] marble = new int[num_marble];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_marble; i++)
            marble[i] = stoi(st.nextToken());

        boolean[] canMakeWithChu = makedp(chu, num_chu);
        StringBuilder sb = new StringBuilder();
        for (int m : marble) {
            if (isCheckable(canMakeWithChu, m)) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb.toString());
    }
}