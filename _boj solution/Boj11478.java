
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int cnt = 0;
        int s_len = s.length();
        for (int len = 1; len <= s_len; len++) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < s_len - len + 1; i++) {
                set.add(s.substring(i, i + len));
            }
            cnt += set.size();
        }
        System.out.println(cnt);
    }
}