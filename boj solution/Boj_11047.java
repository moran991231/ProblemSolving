package done;


import java.io.*;

public class Boj_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]), K = Integer.parseInt(nk[1]);
		int[] coins = new int[N];
		int num_coin = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num <= K)
				coins[i] = num;
			else {
				N = i;
				break;
			}
		}
		for (int i = N - 1; 0 <= i; i--) {
			if (coins[i] <= K) {
				num_coin += K / coins[i];
				K  %= coins[i];
			}
		}

		System.out.print(num_coin);

	}

}
