
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int maxGaroIdx(int[] corners) {
        int max_i = 0;
        for (int i = 2; i < 6; i += 2) {
            if (corners[i] > corners[max_i])
                max_i = i;
        }
        return max_i;
    }

    static int maxSeroIdx(int[] corners) {
        int max_i = 1;
        for (int i = 3; i < 6; i += 2) {
            if (corners[i] > corners[max_i])
                max_i = i;
        }
        return max_i;
    }

    public static void main(String[] args) throws IOException {
        int chamoi = stoi((br.readLine()));
        int[] corners = new int[6];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            corners[i] = stoi(st.nextToken());
        }
        int max_s = maxSeroIdx(corners);
        int max_g = maxGaroIdx(corners);

        int max_i = Math.max(max_s, max_g);
        int min_i = Math.min(max_s, max_g);

        int area = corners[max_s] * corners[max_g];

        if (min_i == 0 && max_i == 5)
            max_i = min_i;

        area -= corners[(max_i + 2) % 6] * corners[(max_i + 3) % 6];

        System.out.println(area * chamoi);

    }
}