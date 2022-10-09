package done;


import java.io.*;
import java.util.*;

public class Boj_9012 {
	static Stack<Byte> s = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final String y = "YES\n", n = "NO\n";

	public static boolean isVPS(String ps) {
		s.clear();
		for (byte ch : ps.getBytes()) {
			if (ch == '(') s.push(ch);
			else if (s.isEmpty()) return false;
			else s.pop();
		}
		if (s.isEmpty()) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		sb.setLength(0);

		for (int i = 0; i < T; i++) {
			if (isVPS(br.readLine())) sb.append(y);
			else sb.append(n);
		}
		System.out.print(sb.toString());

	}

}
