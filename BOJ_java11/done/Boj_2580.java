package done;


import java.io.*;
import java.util.StringTokenizer;

public class Boj_2580 {
	private static int[][] sudoku = new int[9][9];
	private static int[][] blanks = new int[64][2];
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder(172);
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static boolean[][] r_check = new boolean[9][10];
	private static boolean[][] c_check = new boolean[9][10];
	private static boolean[][] sqr_check = new boolean[9][10];

	private static void print_sudoku() {
		sb.setLength(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(sudoku[i][j]).append(' ');
			sb.append('\n');
		}
		try {
			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean dfs(int blank) {
		int x, y, sqr;
		boolean ret;
		if (blank < 0) {
			print_sudoku();
			return true;
		}
		x = blanks[blank][0];
		y = blanks[blank][1];
		sqr = x / 3 * 3 + y / 3;

		for (int num = 1; num < 10; num++) {
			if (!(r_check[x][num] || c_check[y][num] || sqr_check[sqr][num])) {
				r_check[x][num] = c_check[y][num] = sqr_check[sqr][num] = true;
				sudoku[x][y] = num;
				ret = dfs(blank - 1);
				if (ret)
					return true;
				sudoku[x][y] = 0;
				r_check[x][num] = c_check[y][num] = sqr_check[sqr][num] = false;
			}
		}
		return false;

	}

	private static void main_func() {
		int blank_num, num;
		StringTokenizer st;
		blank_num = 0;
		try {
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					num = sudoku[i][j] = Integer.parseInt(st.nextToken());
					r_check[i][num] = true;
					c_check[j][num] = true;
					sqr_check[i / 3 * 3 + j / 3][num] = true;
					if (num == 0) {
						blanks[blank_num][0] = i;
						blanks[blank_num++][1] = j;
					}
				}
			}

		} catch (IOException e) {
		}
		dfs(blank_num - 1);

	}

	public static void main(String[] args) {
		main_func();
	}

}
