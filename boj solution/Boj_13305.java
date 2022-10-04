package done;


import java.io.*;
import java.util.*;

public class Boj_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N];
		long price = Integer.MAX_VALUE;
		long cost=0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			dist[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			price = Math.min(price, Integer.parseInt(st.nextToken()));
			cost += (long) dist[i] * price;
		}

		System.out.println(cost);

	}

}
