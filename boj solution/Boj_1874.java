package done;


import java.io.*;
import java.util.*;

public class Boj_1874 {
	static StringBuilder sb = new StringBuilder();

	public static void push_nums(Stack<Integer> stack, int s, int e) {
		for (int i = s; i <= e; i++) {
			stack.push(i);
			sb.append('+').append('\n');
		}
	}

	public static void main(String[] args) throws IOException {
//		while(true) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int used = 0;
		Stack<Integer> stack = new Stack<Integer>();
		sb.setLength(0);
		int num = 0;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());

			if (used < num) {
				push_nums(stack, used + 1, num);
				used = num;
				stack.pop();
				sb.append('-').append('\n');
			} else if (!stack.isEmpty()) {
				if (num == stack.peek()) {
					stack.pop();
					sb.append('-').append('\n');
				} else {
					System.out.println("NO");
					return;
				}
			} else {
				System.out.println("NO");
				return;

			}

		}

		System.out.println(sb.toString());
//		}
	}

}
