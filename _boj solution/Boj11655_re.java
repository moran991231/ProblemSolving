
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static int getMiddle(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {

        int l_peek = left.isEmpty() ? -10_000 : left.peek();
        int r_peek = right.isEmpty() ? 10_000 : right.peek();

        if (num <= l_peek)
            left.add(num);
        else if (r_peek <= num)
            right.add(num);
        else
            left.add(num);

        int l_size = left.size(), r_size = right.size();
        if (l_size == r_size)
            return left.peek();
        else if (l_size < r_size) {
            int temp = right.poll();
            left.add(temp);
            return temp;
        } else {
            if (l_size == r_size + 1) {
                return left.peek();
            } else {
                right.add(left.poll());
                return left.peek();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        // left.add(-10000);
        // right.add(10000);
        int N = stoi(br.readLine());
        StringBuilder sb = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            int num = stoi(br.readLine());
            sb.append(getMiddle(left, right, num)).append('\n');

        }
        System.out.println(sb.toString());
    }
}
