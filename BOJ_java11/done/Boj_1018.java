package done;

import java.util.Scanner;

class Boj_1018 {
	int N, M;
	char[][] board = new char[50][50];

	int min = 8 * 8;

	void calc_paint() {
		for (int i = 0; i <= N - 8; i++) { for (int j = 0; j <= M - 8; j++) { calc_min(i, j); } }
	}

	void calc_min(int start_r, int start_c) {
		char paint1 = 'W', paint2 = 'B', ch;
		int num1 = 0, num2 = 0;
		for (int i = start_r; i < start_r + 8; i++) {
			for (int j = start_c; j < start_c + 8; j++) {
				ch = board[i][j];
				if (paint1 != ch) num1++;
				else if (paint2 != ch) num2++;
				// swap
				ch = paint1;
				paint1 = paint2;
				paint2 = ch;
			}
			// swap
			ch = paint1;
			paint1 = paint2;
			paint2 = ch;
		}
		num1 = (num1 < num2) ? num1 : num2;
		min = (num1 < min) ? num1 : min;

	}

	void main_func() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++)
				board[i][j] = line.charAt(j);
		}
		sc.close();

		calc_paint();
		System.out.print(min);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boj_1018().main_func();

	}

}
