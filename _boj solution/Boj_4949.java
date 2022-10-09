package done;


import java.io.*;
import java.util.*;

public class Boj_4949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Byte> s = new Stack<Byte>();
	static StringBuilder sb = new StringBuilder();
	static final String y = "yes\n", n = "no\n";

	public static boolean isBracket(byte ch) {
		if (ch == '(' || ch == ')' || ch == '[' || ch == ']') return true;
		return false;
	}

	public static boolean isBalenced(String str) {
		s.clear();
		for (byte ch : str.getBytes()) {
			if (!isBracket(ch)) continue;
			if (ch == '(' || ch == '[') s.push(ch);
			else if (s.isEmpty()) return false;
			else {
				if (ch == ')' && s.peek() == '(') s.pop();
				else if (ch == ']' && s.peek() == '[') s.pop();
				else return false;
			}
		}

		if (s.isEmpty()) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		String str;
		sb.setLength(0);
		while (true) {
			str = br.readLine();
			if (str.equals(".")) break;
			if (isBalenced(str)) sb.append(y);
			else sb.append(n);

		}
		System.out.println(sb.toString());
	}

}
