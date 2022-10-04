package done;

import java.util.Scanner;

class Boj_11444 {
	static final long mod = 1_000_000_007;
	static final long[][] mat = { { 1, 1 }, { 1, 0 } };

	static long[][] mat_dot(long[][] a, long[][]b) {
		long[][] temp = new long[2][2];
		temp[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0]) % mod;
		temp[0][1] = (a[0][0]*b[0][1]+a[0][1]*b[1][1]) % mod;
		temp[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0]) % mod;
		temp[1][1] = (a[1][0]*b[0][1]+a[1][1]*b[1][1]) % mod;
		return temp;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = Long.parseLong(sc.nextLine());
		sc.close();
		long[][] ret = { { 1, 0 }, { 0, 1 } };
		long[][] term = { { 1, 1 }, { 1, 0 } };

		if (N <2) {
			System.out.print(N);
			return;
		}
		while(N>0L) {
			if((N &1) == 1) {
				ret = mat_dot(ret,term);
			}
			N = N>>1;
			term = mat_dot(term,term);
		}

		System.out.print(ret[1][0]);

	}

}
