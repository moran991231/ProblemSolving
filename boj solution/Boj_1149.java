package done;


import java.io.*;
import java.util.StringTokenizer;

public class Boj_1149 {
	static int[][] total; // Nx3


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		total = new int[N+1][3];
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			total[i][0] = Math.min(total[i-1][1], total[i-1][2]) + Integer.parseInt(st.nextToken());
			total[i][1] = Math.min(total[i-1][0], total[i-1][2]) + Integer.parseInt(st.nextToken());
			total[i][2] = Math.min(total[i-1][0], total[i-1][1]) + Integer.parseInt(st.nextToken());		
		}
		
		System.out.println(Math.min(total[N][0], Math.min(total[N][1], total[N][2])));
	}

}
