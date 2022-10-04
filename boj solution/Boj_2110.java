package done;

import java.io.*;
import java.util.*;

class Boj_2110 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int get_cnt(int[] x, long m) {
		int cnt = 1;
		int pre_i = 0;
		for (int i = 1; i < x.length; i++) {
			if (m <= x[i] - x[pre_i]) {
				pre_i = i;
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		int N, C;
		int[] x;
		{
			String[] str = br.readLine().split(" ");

			N = Integer.parseInt(str[0]);
			C = Integer.parseInt(str[1]);
		}
		x = new int[N];
//		Random rand = new Random();
		for (int i = 0; i < N; i++)
			x[i] = Integer.parseInt(br.readLine());
//			x[i] = rand.nextInt(1000000000) + 1;

		Arrays.sort(x);
		long d_min, d_max, mid = 1;
		d_min = 0;
		d_max = 1_000_000_000;

		while (d_min <= d_max) {
			mid = (d_min + d_max + 1) / 2;
			int cnt = get_cnt(x, mid);
			if (C <= cnt) {
				if (d_min == mid) { break; }
				d_min = mid;
			} else d_max = mid - 1;

		}

		System.out.println(mid);
//		System.out.println(get_cnt(x, mid - 1));
//		System.out.println(get_cnt(x, mid));
//		System.out.println(get_cnt(x, mid + 1));

	}

}
