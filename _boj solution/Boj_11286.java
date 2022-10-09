package done;

import java.io.*;

class Boj_11286 {
	static class AbsHeap {
		Node[] heap;
		int size = 0;

		AbsHeap(int N) {
			heap = new Node[N + 1];
		}

		public void add(Node n) {
			if (size == 0) {
				heap[++size] = n;
				return;
			}
			heap[++size] = n;
			int i = size;
			for (int parent = size / 2; 0 < parent; parent /= 2) {
				if (n.compareTo(heap[parent]) < 0) { // n<parent
					swap(parent, i);
					i = parent;
				} else break;
			}

		}

		public int remove() {
			if (size == 0) return 0;
			int ret = heap[1].val;
			heap[1] = heap[size--];
			int i = 1, child = i * 2;

			while (child <= size) {
				if (child + 1 <= size) // L, R
					if (heap[child].compareTo(heap[child + 1]) > 0) // L>R
						child = child + 1;

				if (0 < heap[i].compareTo(heap[child])) { // n>child
					swap(i, child);
					i = child;
				} else break;
				child = i * 2;
			}
			return ret;
		}

		public void swap(int i, int j) {
			Node temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}

	}

	static class Node implements Comparable<Node> {
		int val;

		public Node(int val) {
			this.val = val;
		}

		public int compareTo(Node n) {
			int this_abs = Math.abs(val), n_abs = Math.abs(n.val);
			if (this_abs == n_abs) return this.val - n.val;
			return this_abs - n_abs;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		AbsHeap h = new AbsHeap(N);
		
		int command = 0;
		for (int i = 0; i < N; i++) {
			command = Integer.parseInt(br.readLine());
			if (command != 0)
				h.add(new Node(command));
			else
				sb.append(h.remove()).append('\n');
		}

		System.out.println(sb.toString());

	}

}
