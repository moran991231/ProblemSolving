
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] solutions = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = stoi(st.nextToken());
        }
        Arrays.sort(solutions);
        Complex min = new Complex(solutions[0], solutions[N - 1]);
        Complex temp;
        for (int i = 0; i < N; i++) {
            int si = solutions[i];
            int idx = Arrays.binarySearch(solutions, i + 1, N, -si);
            if (idx >= 0) {
                min = new Complex(si, solutions[idx]);
                break;
            } else {
                idx = -(idx + 1);
                if (idx < N) {
                    temp = new Complex(si, solutions[idx]);
                    if (temp.compareTo(min) < 0)
                        min = temp;
                }
                if (i < idx - 1) {

                    temp = new Complex(si, solutions[idx - 1]);
                    if (temp.compareTo(min) < 0)
                        min = temp;
                }

            }
        }
        System.out.println(min.a + " " + min.b);

    }
}

class Complex implements Comparable<Complex> {
    int a, b, sum;

    public Complex(int i1, int i2) {
        this.a = Math.min(i1, i2);
        this.b = Math.max(i1, i2);
        this.sum = Math.abs(i1 + i2);
    }

    public int compareTo(Complex c) {
        return sum - c.sum;

    }

}