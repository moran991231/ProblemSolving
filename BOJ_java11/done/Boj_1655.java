package done;

import java.io.*;
import java.util.*;

class Boj_1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>((a, b) -> (a - b)); // 오름차 작은거넣기
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>((a, b) -> (b - a)); // 내림차 큰거넣기
		StringBuilder sb = new StringBuilder();

		{
			int num1 = Integer.parseInt(br.readLine());
			sb.append(num1).append('\n');
			if (N == 1) {
				System.out.println(sb.toString());
				return;
			}
			int num2 = Integer.parseInt(br.readLine());
			sb.append(Math.min(num1, num2)).append('\n');

			if (N == 2) {
				System.out.println(sb.toString());
				return;
			}
			pq1.add(Math.max(num1, num2));
			pq2.add(Math.min(num1, num2));
		}
		int num;
		for (int i = 3; i <= N; i++) {
			num = Integer.parseInt(br.readLine());
			if (pq1.peek() <= num) {
				pq1.add(num);
			} else {
				pq2.add(num);
			}
			while (i / 2 < pq1.size())
				pq2.add(pq1.remove());

			while (pq1.size() < i / 2)
				pq1.add(pq2.remove());

			if (i % 2 == 0)
				sb.append(Math.min(pq1.peek(), pq2.peek())).append('\n');
			else
				sb.append(pq2.peek()).append('\n');

		}
		System.out.print(sb.toString());

	}

}
