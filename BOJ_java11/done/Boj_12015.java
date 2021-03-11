package done;

import java.io.*;
import java.util.*;

class Boj_12015 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int lowerBound(int[] lis, int len, int val) {
		int s = 0, e = len, mid = 0;
		while (s <= e) {
			mid = (s + e) / 2;
			if (val <= lis[mid]) {
				if (e == mid) break;
				e = mid;
			} else s = mid + 1;
		}
		return mid;
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] lis = new int[N];
		int top = -1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		lis[++top] = A[0];
		for (int i = 1; i < N; i++) {
			int idx = lowerBound(lis, top + 1, A[i]);
			lis[idx] = A[i];
			if (top < idx) {
				top = idx;
			}

		}

		System.out.println(top + 1);
	}

}
