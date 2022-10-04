package done;

import java.io.*;
import java.util.*;

class Boj_2533 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, min;
	static ArrayList<Integer>[] edges;
	static int[][] dp;
	static boolean[] visited;

	static class Node {
		ArrayList<Node> children = new ArrayList<>();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void dfs(int idx) {
		visited[idx] = true;

		dp[idx][0] = 0;
		dp[idx][1] = 1;

		for (int friend : edges[idx]) {
			if (visited[friend] ==  false) {
				dfs(friend);
				dp[idx][0] += dp[friend][1];
				dp[idx][1] += Math.min(dp[friend][0], dp[friend][1]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		min = Integer.MAX_VALUE;
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];
		edges = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			edges[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

}
