package done;

import java.io.*;
import java.util.*;

public class Boj_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Integer[] P = new Integer[N+1];
		int sum=0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(P,1,N+1,Collections.reverseOrder());
		for(int i=1; i<=N; i++)
			sum += P[i]*i;
		System.out.print(sum);
	}

}
