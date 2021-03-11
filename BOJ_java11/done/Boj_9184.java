package done;


import java.io.*;
import java.util.StringTokenizer;

public class Boj_9184 {
	static int[][][] dp = new int[21][21][21];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (a > 20 || b > 20 || c > 20) {
			if (dp[20][20][20] == 0)
				dp[20][20][20] = w(20, 20, 20);
			return dp[20][20][20];
		}
		if (dp[a][b][c] != 0)
			return dp[a][b][c];
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	public static void main(String[] args) throws IOException {
		int a, b, c, ret;
		if (dp[20][20][20] == 0) { // make dp
			for (a = 0; a < 21; a++)
				for (b = 0; b < 21; b++)
					for (c = 0; c < 21; c++)
						dp[a][b][c] = w(a, b, c);
		}
		while (true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;

			ret = w(a, b, c);
			bw.write(String.format("w(%d, %d, %d) = %d\n", a, b, c, ret));
		}
		bw.flush();

	}

}
