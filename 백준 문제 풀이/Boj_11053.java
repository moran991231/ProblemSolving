package done;


import java.io.*;
import java.util.StringTokenizer;

public class Boj_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N + 1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++)
			A[i][0] = Integer.parseInt(st.nextToken());

		int i, num, max = 0,  len_max;
		for (int n = 1; n <= N; n++) {
			num = A[n][0];
			len_max = 0;
			for (i = n - 1; 1 <= i; i--) {
				if (A[i][0] < num && len_max < A[i][1]) {
					len_max = A[i][1];
				}
			}
			A[n][1] = len_max + 1;
			max = Math.max(max, A[n][1]);
		}

		System.out.print(max);
	}

}
