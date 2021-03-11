package done;


import java.io.*;
import java.util.*;

class Document {
	int importance = 0;
	boolean isInteresting = false;

	Document(int importance) {
		this.importance = importance;
	}

	Document(int importance, boolean interest) {
		this.importance = importance;
		this.isInteresting = interest;
	}

}

public class Boj_1966 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Queue<Document> q = new LinkedList<>();

	public static int calc(int[] nums) {
		int order = 1;
		Document doc;
		for (int i = 9; 1 <= i; i--) {
			while (nums[i] > 0) {
				doc = q.remove();

				if (doc.importance == i) {
					if (doc.isInteresting) return order;
					nums[i]--;
					order++;
				} else q.add(doc);
			}
		}

		return order;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		int N, M;
		sb.setLength(0);
		int[] nums;
		int num;

		for (int t = 0; t < T; t++) {
			q.clear();
			nums = new int[10];
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				nums[num]++;
				if (i == M) q.add(new Document(num, true));
				else q.add(new Document(num));
			}

			sb.append(calc(nums)).append('\n');

		}

		System.out.println(sb.toString());
	}

}
