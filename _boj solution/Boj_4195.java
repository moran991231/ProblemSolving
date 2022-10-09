package done;

import java.io.*;
import java.util.*;

class Boj_4195 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));

	static void func() throws IOException {
		int N = Integer.parseInt(br.readLine());
		Map<String, String> parent = new TreeMap<>();
		Map<String, Integer> num = new TreeMap<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		String a, b;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			b = st.nextToken();
			if (!parent.containsKey(a)) {
				parent.put(a, a);
				num.put(a, 1);
			}
			if (!parent.containsKey(b)) {
				parent.put(b, b);
				num.put(b, 1);
			}

			String root_a = grandParent(parent, a);
			String root_b = grandParent(parent, b);
//			System.out.printf("%s-%s %s-%s \n", a, root_a, b,root_b);
			if (!root_a.equals(root_b)) {
				int num_a = num.get(root_a), num_b = num.get(root_b);
				num.put(root_a, num_a + num_b);
				parent.put(root_b, root_a);
			}
			sb.append(num.get(root_a)).append('\n');
		}
		System.out.print(sb.toString());
	}

	static String grandParent(Map<String, String> parent, String x) {
		String p = x;
		while (!parent.get(p).equals(p))
			p = parent.get(p);
		parent.put(x, p);
		return p;
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) { func(); }
	}

}
