package done;

import java.io.*;
import java.util.*;

 class Boj_1010 {
	static HashMap<Integer, Integer> primes = new HashMap<>();

	static void init_map() {
		primes.put(2, 0);
		primes.put(3, 0);
		primes.put(5, 0);
		primes.put(7, 0);
		primes.put(9, 0);
		primes.put(11, 0);
		primes.put(13, 0);
		primes.put(17, 0);
		primes.put(19, 0);
		primes.put(23, 0);
		primes.put(29, 0);

	}

	static long Combination(int k, int n) {
		long ret = 1;
		k = (k < n - k) ? k : n - k;

		for (int i = n - k + 1; i <= n; i++) {
			int num = i;
			for (int p : primes.keySet()) {
				while (num % p == 0) {
					num /= p;
					primes.put(p, primes.get(p) + 1);
				}
				if (num <= 1)
					break;
			}
		}

		for (int i = 2; i <= k; i++) {
			int num = i;
			for (int p : primes.keySet()) {
				while (num % p == 0) {
					num /= p;
					primes.put(p, primes.get(p) - 1);
				}
				if (num <= 1)
					break;
			}
		}

		for (int p : primes.keySet()) {
			int idx = primes.get(p);
			ret *= Math.pow(p, idx);
		}

		return ret;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = Integer.parseInt(br.readLine());
		for (int i = 0; i < cases; i++) {
			init_map();
			String[] nk = br.readLine().split(" ");
			sb.append(Combination(Integer.parseInt(nk[0]), Integer.parseInt(nk[1]))).append('\n');
		}

		System.out.println(sb.toString());

	}

}
