package done;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_2751 {
	int N;
	ArrayList<Integer> arr = new ArrayList<Integer>();

	void main_func() {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		sc.close();

		Collections.sort(arr);

		for (int num : arr) {
			sb.append(num).append('\n');
		}

		System.out.print(sb.toString());

	}

	public static void main(String[] args) {
		new Boj_2751().main_func();

	}

}
