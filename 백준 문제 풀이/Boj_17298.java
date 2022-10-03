package done;


import java.io.*;
import java.util.*;

public class Boj_17298 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void calcNGE(int[] A) {
		int len = A.length;
		Stack<Integer> stack = new Stack<>();
		int idx;

		for (int i = 0; i < len - 1; i++) {
			if (!stack.isEmpty()) {
				idx = stack.peek();
				while (A[idx] < A[i + 1]) {
					A[idx] = A[i + 1];
					stack.pop();
					if (!stack.isEmpty())
						idx = stack.peek();
					else break;
				}
			}

			if (A[i] < A[i + 1]) A[i] = A[i + 1];
			else stack.push(i);
		}
		while (!stack.isEmpty()) { A[stack.pop()] = -1; }
		A[len - 1] = -1;

	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		calcNGE(A);
		
		for (int i = 0; i < N; i++)
			sb.append(A[i]).append(' ');
		
		System.out.print(sb.toString());
	}

}
