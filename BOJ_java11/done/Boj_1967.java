package done;

import java.io.*;
import java.util.*;

class Boj_1967 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Node[] tree;
	static int dia = 0;

	static class Node implements Comparable<Node> {
		int num, w, w_sum;
		boolean visited = false;
		Node parent = null;
		ArrayList<Node> sib = new ArrayList<>();

		Node() {
		}

		Node(int n) {
			num = n;
		}

		public int compareTo(Node n) {
			return n.w - w;
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int findDiameter() {
		Queue<Node> q = new LinkedList<>();
		int max = 0;
		for (int i = 1; i <= N; i++)
			if (tree[i].sib.size() == 0) {
				q.add(tree[i]);
			}

		while (!q.isEmpty()) {
			Node n = q.remove();
			Node p = n.parent;
			if (n.visited) continue;
			if (p == null) continue;
			if (p.w_sum == 0) p.w_sum = n.w_sum + n.w;
			else {
				max = Math.max(max, p.w_sum + n.w_sum + n.w);
				p.w_sum = Math.max(p.w_sum, n.w_sum + n.w);
			}
			n.visited = true;
			q.add(p);
		}

		max = Math.max(max, tree[1].w_sum);
		return max;
	}

	static int dfs(Node start) {
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(
			Collections.reverseOrder());
		for (Node sib : start.sib) { max.add(dfs(sib)); }
		int a = 0, b = 0;
		if (!max.isEmpty()) a = max.remove();
		if (!max.isEmpty()) b = max.remove();
		if (dia < a + b) dia = a + b;
		return a + start.w;

	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		tree = new Node[N + 1];
		for (int i = 1; i <= N; i++) tree[i] = new Node(i);
		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken()),
				c = stoi(st.nextToken());
			tree[a].sib.add(tree[b]);
			tree[b].parent = tree[a];
			tree[b].w = c;
		}
		int ret = dfs(tree[1]);
		System.out.println(Math.max(ret, dia));
//		System.out.println(findDiameter());
	}

}
