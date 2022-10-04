package done;


import java.io.*;
import java.util.*;

public class Boj_2981 {

	public static int gcd(int x, int y) {
		int temp;
		if (y > x) {
			temp = x;
			x = y;
			y = temp;
		}
		if (x % y == 0)
			return y;
		return gcd(y, x % y);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100);
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int mod;
		int i;
		for (i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		Arrays.sort(nums);

		mod = nums[1] - nums[0];
		for (i = 2; i < N; i++)
			mod = gcd(mod, nums[i] - nums[i - 1]);

		for (i = 2; i <= mod; i++)
			if (mod % i == 0)
				sb.append(i).append(' ');

		System.out.println(sb.toString());

	}

}
