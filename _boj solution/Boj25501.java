
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int cnt = 0;

    static int recursion(String str, int l, int r) {
        cnt++;
        if (l >= r)
            return 1;
        else if (str.charAt(l) != str.charAt(r))
            return 0;
        return recursion(str, l + 1, r - 1);
    }

    static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        int T = stoi(br.readLine());
        StringBuilder sb = new StringBuilder(4 * T);
        for (int i = 0; i < T; i++) {
            cnt = 0;
            sb.append(isPalindrome(br.readLine())).append(' ');
            sb.append(cnt).append('\n');
        }
        System.out.println(sb.toString());
    }
}