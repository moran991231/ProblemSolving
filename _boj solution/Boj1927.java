
import java.io.*;
import java.util.*;

class MyHeap {
    private int size = 0, cap = 0;
    private int[] tree;

    public MyHeap(int capaciticy) {
        cap = capaciticy;
        tree = new int[cap + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int x) {
        tree[++size] = x;

        int loc = size;
        while (1 < loc) {
            if (compare(x, tree[loc / 2]) > 0) {

                swap(loc, loc / 2);
                loc /= 2;
            } else
                break;
        }

    }

    public int peek() {
        return tree[1];
    }

    public int remove() {
        if (size == 0)
            return 0;
        int ret = tree[1];
        int x = tree[1] = tree[size--];

        int loc = 1;
        while (!isLeaf(loc)) {
            int i = loc;
            if (compare(x, tree[loc * 2]) < 0) {
                i = loc * 2;
            }
            if (available(loc * 2 + 1)) {
                if (compare(tree[i], tree[loc * 2 + 1]) < 0) {
                    i = loc * 2 + 1;
                }
            }
            if (i == loc)
                break;
            swap(i, loc);
            loc = i;

        }
        return ret;

    }

    private boolean available(int i) {
        return i <= size;
    }

    private int compare(int a, int b) {
        if (a > b)
            return -1;
        else if (a < b)
            return 1;
        return 0;
    }

    private void swap(int i1, int i2) {
        int temp = tree[i1];
        tree[i1] = tree[i2];
        tree[i2] = temp;
    }

    private boolean isLeaf(int i) {
        return (size < i * 2);
    }

}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        MyHeap heap = new MyHeap(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int cmd = stoi(br.readLine());
            if (cmd == 0) {
                sb.append(heap.remove()).append('\n');

            } else {
                heap.add(cmd);
            }
        }
        System.out.println(sb.toString());
    }
}