package done;


import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2565 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] wires = new int[N + 1][2];
		int max_wire = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			wires[i][0] = Integer.parseInt(st.nextToken());
			wires[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(wires, new Comparator<int[]>() {
			@Override
			public int compare(int[] w1, int[] w2) {
				return w1[1] - w2[1];
			}
		});

		// 최대증가부분수열
		int num, len_max;
		for (int n = 1; n <= N; n++) {
			num = wires[n][0];
			 len_max = 0;
			for (int i = n; 0 <= i; i--) 
				if (wires[i][0] < num)
					if (len_max < wires[i][1]) 
						len_max = wires[i][1];
					
			
			wires[n][1] = len_max+1;
			max_wire = Math.max(max_wire, wires[n][1]);
		}

		System.out.print(N - max_wire);

	}

}
