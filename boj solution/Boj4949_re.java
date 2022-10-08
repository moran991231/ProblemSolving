
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch (ch) {
                case '(':
                case '[':
                    stk.push(ch);
                    break;
                case ')':
                case ']':
                    if (stk.isEmpty())
                        return false;
                    if (stk.peek() == (ch == ')' ? '(' : '['))
                        stk.pop();
                    else
                        return false;
                    break;
            }

        }
        return stk.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(30);
        while (true) {
            String str = br.readLine();
            if (str.length() == 1 && str.charAt(0) == '.')
                break;
            sb.append(isBalanced(str) ? "yes\n" : "no\n");
        }
        System.out.println(sb.toString());

    }
}