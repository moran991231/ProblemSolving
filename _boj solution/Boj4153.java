
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int[] corners = new int[3];
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++)
                corners[i] = stoi(st.nextToken());
            Arrays.sort(corners);
            if (corners[2] == 0)
                break;
            int temp = corners[2] * corners[2];
            temp -= corners[1] * corners[1] + corners[0] * corners[0];
            if (temp == 0)
                sb.append("right\n");
            else
                sb.append("wrong\n");
        }
        System.out.println(sb.toString());
    }
}