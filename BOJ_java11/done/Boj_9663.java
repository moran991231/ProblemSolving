package done;


import java.io.*;

public class Boj_9663 {
	private static int N;
	private static boolean[] diag_RmC;
	private static boolean[] diag_RpC;
	private static boolean[] col;
	private static int num_cases = 0;


	private static void dfs(int r_x, int depth) {
		if (depth <=0) {
			num_cases++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if(diag_RmC[r_x+1-c+N] && diag_RpC[r_x+1+c]&&col[c]) {
				diag_RmC[r_x+1-c+N] = diag_RpC[r_x+1+c]=col[c]=false;
				dfs(r_x + 1, depth - 1);
				diag_RmC[r_x+1-c+N] = diag_RpC[r_x+1+c]=col[c]=true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		diag_RmC = new boolean[2*N];
		diag_RpC = new boolean[2*N];
		col = new boolean[N];
		num_cases = 0;
		for(int i=0; i<2*N; i++)
			diag_RmC[i] = diag_RpC[i]=col[i/2]=true;			

		dfs(-1, N);
		System.out.println(num_cases);
	}

}
