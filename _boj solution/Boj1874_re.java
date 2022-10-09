
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class MyStack {
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        public boolean flag = true;

        public void push(int a) {
            stk.push(a);
            sb.append("+\n");
        }

        public int pop() {
            sb.append("-\n");
            return stk.isEmpty() ? -1 : stk.pop();
        }

        public int peek() {
            return stk.pop();

        }

        public String toString() {
            return flag ? sb.toString() : "NO";
        }

    }

    static String isStackSeq(int[] A) {

        int cur_max = 0;
        MyStack stk = new MyStack();
        for (int x : A) {
            while (cur_max < x) {
                stk.push(++cur_max);
            }
            if (stk.pop() != x) {
                stk.flag = false;
                break;
            }
        }
        return stk.toString();
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = stoi(br.readLine());

        System.out.println(isStackSeq(A));

    }
}