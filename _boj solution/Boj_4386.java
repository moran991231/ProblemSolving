package done;

import java.io.*;
import java.util.*;

class Boj_4396 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Star[] stars;
	static final float INF = 1_000_001.0f;

	static class Star  {
		float x, y;

		Star(float x, float y) {
			this.x = x;
			this.y = y;
		}

		float howFar(Star s) {
			float dx = x - s.x, dy = y - s.y;
			return (float) Math.sqrt(dx * dx + dy * dy);
		}

	}

	static class Edge implements Comparable<Edge> {
		int next;
		float w;

		Edge(int n, float w) {
			this.next = n;
			this.w = w;
		}

		public int compareTo(Edge e) {
			if (e.w < w) return 1;
			else if (w < e.w) return -1;
			else return 0;
		}
	}

	static public float prim() {
		boolean[] isConstell = new boolean[N];
		float cost = 0.0f;
		int cnt = 1;
		isConstell[0] = true;

		PriorityQueue<Edge> q = new PriorityQueue<>();
		for (int i = 1; i < N; i++)
			q.add(new Edge(i, stars[0].howFar(stars[i])));

		while (cnt < N ) {
			Edge e = q.remove();
			if (isConstell[e.next]) continue;
			isConstell[e.next] = true;
			cost += e.w;
			cnt++;
			Star s = stars[e.next];
			for (int i = 1; i < N; i++)
				if (!isConstell[i])
					q.add(new Edge(i, s.howFar(stars[i])));
		}

		return cost;
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		stars = new Star[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			float x = Float.parseFloat(st.nextToken()),
				y = Float.parseFloat(st.nextToken());
			stars[i] = new Star(x, y);
		}

		System.out.println(prim());

	}

}
