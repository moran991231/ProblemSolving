package done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10989 {
	int N;
	int[] arr = new int[10_001];

	void main_func() throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)	);
		
		StringBuilder sb = new StringBuilder(6_000_000);
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		br.close();

		for (int i = 0; i < arr.length; i++) {
			while (arr[i] > 0) {
				sb.append(i).append('\n');
				arr[i]--;
				N--;
				if (N % 1_000_000 == 0) {
					System.out.print(sb.toString());
					sb.setLength(0);
				}
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		new Boj_10989().main_func();

	}

}
