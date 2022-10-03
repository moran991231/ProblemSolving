package done;

import java.io.*;
import java.util.*;

class Boj_1520 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N;
	static int[][] map;
	static int[][] visited;
	static final int[] di = { -1, +1, 0, 0 }, dj = { 0, 0, -1, +1 };

	static boolean available(int val, int i, int j) {
		if (0 <= i && i < M && 0 <= j && j < N)
			if (val > map[i][j]) return true;
		return false;
	}

	static int dfs(int i, int j) {
		if (i == M - 1 && j == N - 1) return 1;
		if (visited[i][j] >= 0) return visited[i][j];
		
		int sum=0;
		for (int d = 0; d < 4; d++) {
			int x = i + di[d], y = j + dj[d];
			if (available(map[i][j], x, y))
				sum += dfs(x, y);
		}
		
		if(visited[i][j]<0) visited[i][j]=0;
		if(sum>=0) visited[i][j] += sum;
		
		return visited[i][j];

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j]=-1;
			}
		}
		visited[M - 1][N - 1] = 1;
		dfs(0, 0);
		System.out.println(visited[0][0]);

	}

}
