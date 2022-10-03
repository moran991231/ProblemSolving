package done;

import java.util.Scanner;

class Boj_1629 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B, C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		sc.close();
		A = A%C;
		long ret = 1;
		long term = A;
		for (int digit = 0; digit < 31; digit++) {
			if (((B >> digit) & 1) == 1)
				ret = (ret * term) % C;
			term = (term * term) % C;
		}
		System.out.print(ret);

	}

}
