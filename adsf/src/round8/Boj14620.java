package round8;

import java.io.*;
import java.util.*;

class Main_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int[] dr = { 0, -1, 0, 1, 0 }, dc = { 0, 0, 1, 0, -1 };

	static int N, price;
	static int[][] G;
	static boolean[][] disabled;

	static int min;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int plant(int r, int c) {
		for (int i = 0; i < 5; i++) {
			if (disabled[r + dr[i]][c + dc[i]])
				return -1;
		}
		int ret = 0;
		for (int i = 0; i < 5; i++) {
			ret += G[r + dr[i]][c + dc[i]];
		}
		return ret;
	}

	
	
	static void fill(int r, int c, boolean f) {
		for (int i = 0; i < 5; i++)
			disabled[r + dr[i]][c + dc[i]] = f;
	}

	static void dfs(int r, int c, int depth, int price) {
		int temp;
		//
		if (depth >3)
			return;
		
		depth++;
// 1~N.. 2~N-1
		for (int i = r; i <= N - 1; i++) {
			
			
			for (int j = c; j <= N - 1; j++) {
				temp = plant(i, j);
				if (temp == -1)
					continue;

				fill(i, j, true);
				dfs(i, j, depth, price + temp);
				// depth : 심은 꽃의 개수
				fill(i, j, false);

				if (depth == 3) {
					min = Math.min(price + temp, min);
				}

			}
			
			
			
		}

	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		min = Integer.MAX_VALUE;
		N = stoi(br.readLine());
		G = new int[N + 1][N + 1];
		disabled = new boolean[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				G[i][j] = stoi(st.nextToken());
			}
		}
		
		
		
		for (int i = 0; i <= N + 1; i++) {

			disabled[0][i] = true;
			disabled[N + 1][i] = true;
			disabled[i][0] = true;
			disabled[i][N + 1] = true;
		}

		dfs(2, 2, 0, 0);
		System.out.println(min);

	}
}
