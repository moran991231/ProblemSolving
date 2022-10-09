package done;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	static int N;
	static int M;
	static int[][] S;
	static int min = Integer.MAX_VALUE;
	static boolean[] enabled;
	
	static void calc_min_diff() {
		int s_start = 0, s_link = 0;
		for (int p1 = 1; p1 <= N; p1++) {
			for (int p2 = p1 + 1; p2 <= N; p2++) {
				if (enabled[p1] && enabled[p2])
					s_link += S[p1][p2];
				else if (!(enabled[p1] || enabled[p2]))
					s_start += S[p1][p2];
			}
		}
		min = Math.min(min, Math.abs(s_start - s_link));
		

	}

	static void dfs(int player, int idx) {
		if (idx >= M ) {
			calc_min_diff();
			return;
		}

		for (int p = player; p <= N; p++) {
			enabled[p] = false;
			dfs(p+1, idx + 1);
			enabled[p] = true;
		}
	}

	void main_func() throws IOException {
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = N / 2 ;
		S = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		enabled = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			enabled[i] = true;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				S[i][j] += S[j][i];
			}
		}
		dfs(1, 0);
		System.out.println(min);
	}

}
