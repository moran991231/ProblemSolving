package done;

import java.io.*;

class Boj_1003 {
	public static int[] dp = new int[42];
	public static int M;
	public static StringBuilder sb = new StringBuilder();

	private static void make_dp() {
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i < 42; i++) { dp[i] = dp[i - 1] + dp[i - 2]; }
	}

	public static void main(String[] args) {
		if (dp[0] == 0)
			make_dp();
		sb.setLength(0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		try {
			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				num = Integer.parseInt(br.readLine());
				sb.append(dp[num]).append(' ').append(dp[num + 1]).append('\n');
			}
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e) {}

	}

}
