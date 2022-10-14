
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static String strExplosion(char[] orig, Map<Character, Character> ancestor, char bomb) {
        Stack<Character> stk = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for (char ch : orig) {
            if (ch == bomb) {
                temp.clear();
                temp.push(bomb);
                while (!stk.isEmpty()) {
                    char temp_anc = ancestor.get(temp.peek());
                    if (temp_anc == stk.peek()) {
                        temp.push(stk.pop());
                    } else
                        break;
                }
                if (ancestor.get(temp.peek()) == 0) // exploded
                    temp.clear();
                while (!temp.isEmpty()) {
                    stk.push(temp.pop());
                }

            } else {
                stk.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder(stk.size());
        if (stk.size() == 0)
            return "FRULA";

        for (char x : stk) {
            sb.append(x);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        char[] orig = br.readLine().toCharArray();
        char[] fire = br.readLine().toCharArray();
        Map<Character, Character> ancestor = new HashMap<>(26 + 26 + 10);
        for (int i = 0; i < 26; i++) {
            ancestor.put((char) (i + 'A'), (char) 0);
            ancestor.put((char) (i + 'a'), (char) 0);
        }
        for (int i = 0; i <= 9; i++) {
            ancestor.put((char) (i + '0'), (char) 0);

        }
        for (int i = 1; i < fire.length; i++) {
            ancestor.put(fire[i], fire[i - 1]);
        }
        String ret = strExplosion(orig, ancestor, fire[fire.length - 1]);
        System.out.println(ret);

    }
}