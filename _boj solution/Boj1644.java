
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] primes, prime_sum;
    static boolean[] isNotPrime;
    static final int N_MAX = 4_000_000;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static void makePrime() {
        ArrayList<Integer> prime, prime_sqr;
        prime = new ArrayList<>(283146);
        prime_sqr = new ArrayList<>(283146);
        prime.add(2);
        prime_sqr.add(4);
        for (int n = 3; n < N_MAX; n++) {
            boolean isPrime = true;
            for (int i = 0; prime_sqr.get(i) <= n; i++) {
                if (n % prime.get(i) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime.add(n);
                prime_sqr.add(n * n);
            }
        }
        prime_sqr = null;
        int len = prime.size();
        // System.out.println(len);

        prime_sum = new int[len + 1];
        primes = new int[len + 1];
        for (int i = 0; i < len; i++) {
            primes[i + 1] = prime.get(i);
            prime_sum[i + 1] = prime_sum[i] + primes[i + 1];
        }
    }

    static void makeBoolPrime() {
        isNotPrime = new boolean[N_MAX + 1];
        for (int n = 2; n * n <= N_MAX; n++) {
            if (!isNotPrime[n]) {
                for (int k = n * n; k <= N_MAX; k += n) {
                    isNotPrime[k] = true;
                }
            }
        }
    }

    static int calc(int N) {
        if (prime_sum == null)
            makePrime();
        int cnt = 0;
        int s = 1, e = 1;
        int temp;
        int len = primes.length;
        while (e < len) {
            if (primes[e] > N)
                break;
            temp = prime_sum[e] - prime_sum[s - 1];
            if (temp == N) {
                // System.out.printf("%d ~ %d\n", primes[s], primes[e]);
                cnt++;
                s++;
                e++;
            } else if (N < temp) {
                s++;
            } else {
                e++;
            }
        }

        return cnt;
    }

    static int getNextPrimeIdx(int idx) {
        for (int i = idx + 1; i <= N_MAX; i++) {
            if (!isNotPrime[i])
                return i;
        }
        return N_MAX + 1;
    }

    static int calc2(int N) {
        if (isNotPrime == null)
            makeBoolPrime();

        int cnt = 0;
        int s = 2, e = 2;
        int sum = 2;

        while (e < N + 1) {

            if (sum == N) {
                cnt++;
                e = getNextPrimeIdx(e);
                sum += e;
                sum -= s;
                s = getNextPrimeIdx(s);

            } else if (sum < N) {
                e = getNextPrimeIdx(e);
                sum += e;
            } else {
                sum -= s;
                s = getNextPrimeIdx(s);
            }
        }
        return cnt;

    }

    public static void main(String[] args) throws IOException {

        int N = stoi(br.readLine());
        // int ret = calc(N);
        int ret = calc2(N);
        System.out.println(ret);

    }
}