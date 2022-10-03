package done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10828 {
	int[] stack = new int[10001];
	int top = -1;

	void main_func() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100_000);

		int N = Integer.parseInt(br.readLine());
		int command;
		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			command = line.charAt(0);
			if (command == 'p') {
				if (line.charAt(1) == 'u') {
					stack[++top] = Integer.parseInt(line.substring(5));
				} else {
					if (top < 0)
						sb.append(-1).append('\n');
					else {
						sb.append(stack[top--]).append('\n');
					}
				}

			} else if (command == 's') {
				sb.append(top + 1).append('\n');

			} else if (command == 'e') {
				sb.append((top < 0) ? 1 : 0).append('\n');

			} else if (command == 't') {
				if (top < 0)
					sb.append(-1).append('\n');
				else
					sb.append(stack[top]).append('\n');
			}
			line = null;
			if (i == 10000) {
				System.out.print(sb.toString());
				sb.setLength(0);
			}

		}
		br.close();
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		new Boj_10828().main_func();
	}

}
