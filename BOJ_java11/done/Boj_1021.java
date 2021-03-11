package done;

import java.util.*;

public class Boj_1021 {

	static int calc(Deque<Integer> dq, int target) {
		int order = 0, size = dq.size();
		int num;
		while ((num = dq.removeFirst()) != target) {
			order++;
			dq.add(num);
		}
		order = Math.min(order, size - order);
		return order;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		Deque<Integer> dq = new LinkedList<>();

		N = sc.nextInt();
		M = sc.nextInt();
		int sum = 0;

		for (int i = 1; i <= N; i++)
			dq.add(i);

		for (int i = 0; i < M; i++)
			sum += calc(dq, sc.nextInt());

		sc.close();

		System.out.print(sum);

	}

}
