package done;

import java.io.*;

class Boj_2630 {
	static int blue = 0, white = 0;
	static char[][] paper;

	static void devide(int r, int c, int n) {
		char color = paper[r][c];
		if (n == 1) {
			if (color == '0') white++;
			else blue++;
			return;
		}
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++)
				if (color != paper[i][j]) {
					color = 0;
					break;
				}
			if (color == 0) break;
		}

		if (color == '0') {
			white++;
		} else if (color == '1') {
			blue++;
		} else {
			int n2 = n / 2;
			int rr = r + n2, cc = c + n2;
			devide(r, c, n2);
			devide(rr, c, n2);
			devide(r, cc, n2);
			devide(rr, cc, n2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new char[N][];
		for (int i = 0; i < N; i++)
			paper[i] = br.readLine().replaceAll(" ", "").toCharArray();
		blue = white = 0;
		devide(0, 0, N);
		System.out.printf("%d \n%d", white, blue);

	}

}
