package done;


import java.util.Scanner;

public class Boj_2004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		long num_2 = 0, num_5 = 0;
		int temp;

		temp = N;
		while (temp > 1) {
			temp /= 2;
			num_2 += temp;
		}

		temp = N;
		while (temp > 1) {
			temp /= 5;
			num_5 += temp;
		}

		temp = M;
		while (temp > 1) {
			temp /= 2;
			num_2 -= temp;
		}

		temp = M;
		while (temp > 1) {
			temp /= 5;
			num_5 -= temp;
		}
		temp = N - M;
		while (temp > 1) {
			temp /= 2;
			num_2 -= temp;
		}

		temp = N - M;
		while (temp > 1) {
			temp /= 5;
			num_5 -= temp;
		}

		System.out.print(Math.min(num_2, num_5));

	}

}
