package done;

import java.io.*;
import java.util.StringTokenizer;

class Boj_1780 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] paper;
	static int minus1, zero, plus1;

	static void nineTree(int r, int c, int n) {
		int color = paper[r][c];
		if (n == 1) {
			if (color == -1) minus1++;
			else if (color == 0) zero++;
			else plus1++;
			return;
		}

		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (color != paper[i][j]) {
					color = 100;
					break;
				}
			}
			if (color == 100) break;
		}

		if (color == -1) minus1++;
		else if (color == 0) zero++;
		else if (color == 1) plus1++;
		else {
			int nn = n / 3;
			nineTree(r, c, nn);
			nineTree(r, c + nn, nn);
			nineTree(r, c + nn * 2, nn);
			nineTree(r + nn, c, nn);
			nineTree(r + nn, c + nn, nn);
			nineTree(r + nn, c + nn * 2, nn);
			nineTree(r + nn * 2, c, nn);
			nineTree(r + nn * 2, c + nn, nn);
			nineTree(r + nn * 2, c + nn * 2, nn);

		}

	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		paper = new int[N][N];
		minus1 = zero = plus1 = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] =  Integer.parseInt(st.nextToken());
		}
		nineTree(0, 0, N);
		System.out.printf("%d \n%d \n%d", minus1, zero, plus1);

	}

}
