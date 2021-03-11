package done;


import java.io.*;

public class Boj_10844 {
	static int[] base = new int[12], sum = new int[12];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long ret = 0;
		int[] temp;
		for (int i = 2; i <= 10; i++)
			base[i] = 1;
		for (int n = 1; n < N; n++) {
			for (int i = 1; i <= 10; i++)
				sum[i] = (base[i - 1] + base[i + 1])%1_000_000_000;
			temp = sum;
			sum = base;
			base = temp;
		}

		for (int i = 1; i <= 10; i++)
			ret += base[i]%1_000_000_000l;
		System.out.println(ret%1_000_000_000l);

	}
}
