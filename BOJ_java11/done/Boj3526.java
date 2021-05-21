package done;

import java.io.*;
import java.util.*;

class Main_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static Room[] rooms;

	static class Room {
		Map<Integer, Integer> lobbies = new TreeMap<>();
		ArrayList<Integer> path = new ArrayList<>();
		boolean visited = false;
		boolean inQue=false;

		boolean comparePath(ArrayList<Integer> p, int c) {
			if (this.visited == false)
				return true;
			int size = p.size();
			if (path.size() < size + 1)
				return false;
			if (path.size() > size + 1)
				return true;

			for (int i = 0; i < size; i++) {
				int a = path.get(i), b = p.get(i);
				if (a < b)
					return false;
				else if (a > b)
					return true;
			}
			if (path.get(size) < c)
				return false;
			if (path.get(size) > c)
				return true;

			return false;
		}

		void replacePath(ArrayList<Integer> p, int c) {
			path.clear();
			for (int x : p)
				path.add(x);
			path.add(c);
		}

		void addLobby(int n, int c) {
			if (lobbies.containsKey(n)) {
				int val = lobbies.get(n);
				if (c < val)
					lobbies.put(n, c);
			} else
				lobbies.put(n, c);
		}
	}

	static void bfs() {
		Queue<Room> q = new LinkedList<>();
		q.add(rooms[1]);
		rooms[1].visited = true;
		rooms[1].inQue=true;

		while (!q.isEmpty()) {
			Room cur = q.remove();
			cur.inQue=false;
			
			for (Map.Entry<Integer, Integer> lb : cur.lobbies.entrySet()) {
				Room next = rooms[lb.getKey()];
				int color = lb.getValue();
				
				if (next.comparePath(cur.path, color)) {
					next.replacePath(cur.path, color);
					next.visited = true;
					if(next.inQue==false) {
						q.add(next);
						next.inQue=true;						
					}
				}
			}
		}

		sb.append(rooms[N].path.size()).append('\n');
		for (int p : rooms[N].path)
			sb.append(p).append(' ');
		return;

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		rooms = new Room[N + 1];
		for (int i = 1; i <= N; i++)
			rooms[i] = new Room();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken()), c = stoi(st.nextToken());
			if (a == b)
				continue;
			rooms[a].addLobby(b, c);
			rooms[b].addLobby(a, c);

		}

		bfs();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
