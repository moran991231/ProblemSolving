package done;

import java.io.*;
import java.util.*;

class Boj_2740 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N, M, K;
		byte[][] A, B;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new byte[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				A[i][j] = Byte.parseByte(st.nextToken());

		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = new byte[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<K; j++)
				B[i][j] = Byte.parseByte(st.nextToken());

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) { 
				int ret=0;
				for (int m = 0; m < M; m++) {
					ret += A[i][m] * B[m][j]; 
				}
				sb.append(ret).append(' ');
				ret=0;
			}
			sb.append('\n');
		}
		
		System.out.print(sb.toString());

	}

}
