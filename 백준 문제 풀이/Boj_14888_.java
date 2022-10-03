package done;

import java.util.Scanner;

public class Boj_14888_ {
	int N, M;
	int[] A = new int[11];
	int[] OP = new int[10];
	int[] num_op = new int[5];
	final int PLUS = 1, MINUS = 2, MULTIPLY = 3, DIVIDE = 4;
	int min, max;
	boolean init_flag = true;

	void clear_OP() {
		for (int i = 0; i < 10; i++)
			OP[i] = 0;
	}


	void fill_OP(int bits, int target, int operator) {
		for (int i = 0; i < M; i++) {
			if (OP[i] == target) {
				OP[i] = ((bits & 1) == 1) ? operator : 0;
				bits >>= 1;
			if(bits<=0)break;
			}
		}
	}

	int calc_weight(int x, int len) {
		int weight = 0;
		for (int i = 0; i < len; i++)
			weight += (x >> i) & 1;
		return weight;
	}

	int Choose_next(int bits, int num, int space) {
		int max = ((1 << (num)) - 1) << (space - num);
		bits++;
		while (bits <= max) {
			if (calc_weight(bits, space) == num)
				return bits;
			bits++;
		}
		return -1;
	}

	void calc_A() {
		int ret = A[0];

		for (int i = 0; i < M; i++) {
//			System.out.print(OP[i]);
			if (OP[i] == PLUS)
				ret += A[i + 1];
			else if (OP[i] == MINUS)
				ret -= A[i + 1];
			else if (OP[i] == MULTIPLY)
				ret *= A[i + 1];
			else if (OP[i] == DIVIDE)
				ret /= A[i + 1];
		}
//		System.out.println();

		if (init_flag) {
			min = max = ret;
			init_flag = false;
		} else {
			if (ret < min)
				min = ret;
			else if (max < ret)
				max = ret;
		}

	}

	void all_case() {
		int bits_plus = (1 << (num_op[PLUS] )) - 1 - 1;
		int bits_minus = (1 << (num_op[MINUS] )) - 1 - 1;
		int bits_multiply = (1 << (num_op[MULTIPLY] )) - 1 - 1;
		int bits_divide = (1 << (num_op[DIVIDE] )) - 1 - 1;

		int space_plus = M;
		int space_minus = space_plus - num_op[PLUS];
		int space_multiply = space_minus - num_op[MINUS];
		int space_divide = num_op[DIVIDE];
//		System.out.println(bits_plus);

		while (true) {
			bits_plus = Choose_next(bits_plus, num_op[PLUS], space_plus);
//			System.out.println(bits_plus);
			if (bits_plus < 0)
				break;
			fill_OP(bits_plus, 0,PLUS);

			while (true) {
				bits_minus = Choose_next(bits_minus, num_op[MINUS], space_minus);
				if (bits_minus < 0)
					break;
				fill_OP(bits_minus, 0,MINUS);

				while (true) {
					bits_multiply = Choose_next(bits_multiply, num_op[MULTIPLY], space_multiply);
					if (bits_multiply < 0)
						break;
					fill_OP(bits_multiply,0, MULTIPLY);

					while (true) {
						bits_divide = Choose_next(bits_divide, num_op[DIVIDE], space_divide);
						if (bits_divide < 0)
							break;
						fill_OP(bits_divide, 0,DIVIDE);
						calc_A();
						fill_OP(bits_divide,DIVIDE, 0);
					}
					fill_OP(bits_multiply,MULTIPLY, 0);
				}
				fill_OP(bits_minus,MINUS, 0);
			}
			clear_OP();

		}
//		System.out.println();
		System.out.println(max);
		System.out.println(min);

	}

	void main_func() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = N - 1;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			num_op[i + 1] = sc.nextInt();
		}
		sc.close();
		
		all_case();

	}

	public static void main(String[] args) {
		new Boj_14888_().main_func();
	}

}
