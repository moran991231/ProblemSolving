package done;


import java.util.Scanner;

public class Boj_11060 {

	public static void main(String[] args) {
		int N, K, denominator = 1, numerator = 1;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();

		for (int i = 1; i <= K; i++) {
			numerator *= (N - i + 1);
			denominator *= i;
		}
		System.out.print(numerator / denominator);

	}

}
