package done;


import java.util.Scanner;

public class Boj_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, min, max, gcd = 1, lcm = 0;
		x = sc.nextInt();
		y = sc.nextInt();
		sc.close();

		min = Math.min(x, y);
		max = Math.max(x, y);
		x = max;
		y = min;

		while (y != 0) {
			gcd = x % y;
			x = y;
			y = gcd;
		}
		gcd = x;

		lcm = min * max / gcd;
		System.out.println(gcd);
		System.out.println(lcm);

	}
}
