package done;

import java.io.*;

class Boj_19590 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long total = 0, max = 0;

		for (int i = 0; i < N; i++) {
			int bead = Integer.parseInt(br.readLine());
			if (max < bead) max = bead;
			total += bead;
		}
		if (total <= max * 2)
			total = max * 2 - total;
		else total %= 2;
		System.out.println(total);

	}

}
