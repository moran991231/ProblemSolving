package done;

import java.util.Scanner;

// DFS
public class Boj_14888 {

	int N = 0;
	int[] A = new int[11];
	int[] num_OP = new int[4]; // +,-,*,/
	int[] OP = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	int min = 1000000000, max = -1000000000;

	void fill_OP(int idx, int operator) {
		if (1 <= idx && idx < N) {
			OP[idx] = operator;
			num_OP[operator]--;
		}
		if (idx >= N - 1) { // last idx of OP[]
			calc();
			num_OP[operator]++;
			return;
		}

		for (int op = 0; op < 4; op++) {
			if (num_OP[op] > 0)
				fill_OP(idx + 1, op);
		}
		if (operator >= 0)
			num_OP[operator]++;

	}

	void calc() {
		int result = A[0];

		for (int i = 1; i < N; i++) {
			if (OP[i] == 0)
				result += A[i];
			else if (OP[i] == 1)
				result -= A[i];
			else if (OP[i] == 2)
				result *= A[i];
			else
				result /= A[i];
		}
		if (result < min)
			min = result;
		if (max < result)
			max = result;
	}

	void main_func() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		for (int i = 0; i < 4; i++) {
			num_OP[i] = sc.nextInt();
		}

		sc.close();

		fill_OP(0, -1);

		System.out.println(max);
		System.out.println(min);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boj_14888().main_func();
	}

}
