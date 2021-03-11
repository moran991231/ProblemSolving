package done;


import java.io.*;

public class Boj_2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int accum = 0;
		int[] step = new int[N + 1];
		int[] score = new int[N + 1];

		for (int i = 1; i < N + 1; i++)
			step[i] = Integer.parseInt(br.readLine());
		score[1] = step[1];
		if (N==1) {
			System.out.print(score[N]);
			return;
		}
		score[2] = score[1] + step[2];
		accum = 2;

		int temp1, temp2, temp3;

		for (int i = 3; i < N + 1; i++) {
			temp1 = accum < 2 ? score[i - 1] + step[i] : 0;
			temp2 = score[i - 2] + step[i];
			temp3 = score[i - 3] + step[i - 1] + step[i];
			if (temp1 >= temp2 && temp1 >= temp3) {
				score[i] = temp1;
				accum++;
			} else if (temp2 >= temp1 && temp2 >= temp3) {
				score[i] = temp2;
				accum = 1;
			} else if (temp3 >= temp1 && temp3 >= temp2) {
				score[i] = temp3;
				accum = 2;
			}
		}

		System.out.print(score[N]);

	}

}
