package done;
import java.util.Scanner;

public class Boj_20057 {
	int N;
	int[][] A = new int[499][499];
	int x, y;

	int dir = 0, dist = 1;
	int sand = 0;
	int[] fly_sand = new int[10];
	final int[][] sand_r = { { 1, 3, 0, 4, 1, 3, 1, 3, 2, 2 }, { 1, 1, 2, 2, 2, 2, 3, 3, 4, 3 },
			{ 1, 3, 0, 4, 1, 3, 1, 3, 2, 2 }, { 3, 3, 2, 2, 2, 2, 1, 1, 0, 1 } };
	final int[][] sand_c = { { 3, 3, 2, 2, 2, 2, 1, 1, 0, 1 }, { 1, 3, 0, 4, 1, 3, 1, 3, 2, 2 },
			{ 1, 1, 2, 2, 2, 2, 3, 3, 4, 3 }, { 1, 3, 0, 4, 1, 3, 1, 3, 2, 2 } };

	void main_func() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				A[i][j] = sc.nextInt();
		}
		sc.close();
		x = y = N / 2;

		while (x >= 0 && y >= 0) {
			straight_routine();
		}
		System.out.print(sand);
	}

	void straight_routine() {
		for (int n = 0; n < dist; n++) {
			if (dir == 0) { // left
				y--;
			} else if (dir == 1) { // down
				x++;
			} else if (dir == 2) { // right
				y++;
			} else if (dir == 3) { // up
				x--;
			}
			if (!(0 <= x && x < N && 0 <= y && y < N))
				return;
			cal_sand(x, y);
//			A[x][y] = 9;
//			System.out.printf("%d %d \n",x,y);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++)
//					System.out.printf("%2d", A[i][j]);
//				System.out.println();
//			}
//			System.out.println();
		}

		dist += dir % 2;
		dir = (dir + 1) % 4;

	}

	void cal_sand(int cx, int cy) {
		int orig_sand = A[cx][cy];
		int remain = orig_sand;
		fly_sand[0] = fly_sand[1] = (int) ((float) orig_sand * 1.0f / 100.0f);
		fly_sand[2] = fly_sand[3] = (int) ((float) orig_sand * 2.0f / 100.0f);
		fly_sand[4] = fly_sand[5] = (int) ((float) orig_sand * 7.0f / 100.0f);
		fly_sand[6] = fly_sand[7] = (int) ((float) orig_sand * 10.0f / 100.0f);
		fly_sand[8] = (int) (orig_sand * 5.0 / 100.0);

		for (int i = 0; i < 10 - 1; i++)
			remain -= fly_sand[i];
		fly_sand[9] = remain;

		A[cx][cy] = 0;

		int r, c;
		for (int i = 0; i < 10; i++) {
			r = cx + sand_r[dir][i] - 2;
			c = cy + sand_c[dir][i] - 2;
			if (0 <= r && r < N && 0 <= c && c < N) {
				A[r][c] += fly_sand[i];
			} else {
				this.sand += fly_sand[i];
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boj_20057().main_func();

	}

}
