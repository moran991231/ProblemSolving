package done;


import java.io.*;

public class Boj_15652 {
	static int N, M;
	static int[] arr = new int[8];
	static StringBuilder sb = new StringBuilder(200);

	static void dfs(int num, int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++)
				sb.append(arr[i]).append(' ');
			sb.append('\n');
			return;
		}
		for (int n = num; n <= N; n++) {
			arr[idx] = n;
			dfs(n, idx + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		N = Integer.parseInt(tokens[0]);
		M = Integer.parseInt(tokens[1]);

		dfs(1, 0);
		System.out.print(sb.toString());

	}

}
