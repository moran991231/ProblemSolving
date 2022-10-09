package done;


import java.util.Scanner;

public class Boj_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int num_2 = 0, num_5 = 0;

		for (int n = 2; n <= N; n++) {
			int num = n;
			while (num % 2 == 0) {
				num_2++;
				num /= 2;
			}
			while (num % 5 == 0) {
				num_5++;
				num /= 5;
			}
		}
		
		System.out.print(Math.min(num_2, num_5));

	}

}
