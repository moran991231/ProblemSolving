package done;

import java.io.*;
import java.util.*;

class Boj_2606 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static Computer[] comp;

	static class Computer {
		boolean visited = false;
		ArrayList<Computer> edge = new ArrayList<>();

		void add(Computer c) {
			edge.add(c);
		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int bfs() {
		int cnt = 0;
		Queue<Computer> q = new LinkedList<>();
		q.add(comp[1]);

		while (!q.isEmpty()) {
			Computer c = q.remove();
			if (c.visited)
				continue;
			c.visited = true;
			cnt++;

			for (Computer n : c.edge) {
				q.add(n);
			}
		}
		return cnt - 1;
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		int m = stoi(br.readLine());

		comp = new Computer[N + 1];
		for (int i = 1; i <= N; i++)
			comp[i] = new Computer();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken());
			comp[a].add(comp[b]);
			comp[b].add(comp[a]);
		}
		System.out.println(bfs());
	}

}
