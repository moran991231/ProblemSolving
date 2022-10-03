package done;


import java.util.*;

public class Boj_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		Queue<Integer> q = new LinkedList<>();
		if (N == 1) {
			System.out.println("1");
			return;
		}
		for (int i = 1; i <= N; i++)
			q.add(i);

		q.remove();
		while (q.size() != 1) {
			q.add(q.remove());
			q.remove();
		}
		System.out.println(q.remove());
	}

}
