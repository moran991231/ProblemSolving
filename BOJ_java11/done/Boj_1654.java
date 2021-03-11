package done;

import java.io.*;

class Boj_1654 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int cnt(long[] a, int size, long len) {
		long n = 0;
		for (int i = 0; i < size; i++) {
			n += a[i] / len;
			if (n > 1_000_000) {
				n = 1_000_001;
				break;
			}
		}
		return (int) n;
	}

	public static void main(String[] args) throws IOException {
		int N, K;
		String[] str = br.readLine().split(" ");
		K = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		long[] a = new long[K];
		long max = 0;
		for (int i = 0; i < K; i++) {
			a[i] = Long.parseLong(br.readLine());
			max = Math.max(max, a[i]);
		}

		long s = 1, e = max, len = 0;
		long ans = 0;
		while (s <= e) {
			len = (s + e+1) / 2;
			long n = cnt(a, K, len);

			if (N <= n) {
				if (s == len)
					break;
				ans = Math.max(len, ans);
				s = len;
			} else {
				e = len - 1;
			}
		}

		System.out.println(len);
	}

}
