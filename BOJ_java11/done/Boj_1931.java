package done;


import java.io.*;
import java.util.*;

public class Boj_1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] meets = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meets[i][0] = Integer.parseInt(st.nextToken());
			meets[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meets, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1] == b[1])
					return a[0] - b[0];
				return a[1] - b[1];
			}
		});

		int sum = 0, end = 0;
		int mi[];
		for (int i = 0; i < N; i++) {
			mi = meets[i];
			if (end <= mi[0]) {
				sum++;
				end = mi[1];
			}
		}

		System.out.println(sum);

	}

}
