
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int factorial(int n) {
        if (n <= 1)
            return 1;
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        System.out.println(factorial(N));
    }
}