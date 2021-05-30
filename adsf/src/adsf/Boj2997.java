package adsf;

import java.io.*;
import java.util.*;

class Boj2997 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[3];
		int ret = 0;
		for (int i = 0; i < 3; i++)
			nums[i] = stoi(st.nextToken());
		Arrays.sort(nums);

		int d1 = nums[1] - nums[0], d2 = nums[2] - nums[1];
		if (d1 < d2)
			ret = nums[1] + d1;
		else if (d1 > d2)
			ret = nums[0] + d2;
		else {

			ret = nums[2] + d1;
			if (ret > 100)
				ret = nums[0] - d1;
		}
		System.out.println(ret);

	}

}
