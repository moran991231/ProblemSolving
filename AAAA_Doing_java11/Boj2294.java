import java.io.*;
import java.util.*;

class Boj2294 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static List<Integer> coins = new ArrayList<>();
	static final int MAX = 10001;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int solve() {
		if(coins.get(0)>K) return -1;
		else if (coins.get(0)==K) return 1;
		int dp[] = new int[K + 1];
		Arrays.fill(dp, MAX);
		int biggest = 0;
		dp[coins.get(biggest)] = 1;
		for (int k = coins.get(biggest)+1; k <= K; k++) {
			if (k == coins.get(biggest + 1)) {
				biggest++;
				dp[k] = 1;
				continue;
			}
			int min = MAX;
			for (int i = 0; i <= biggest; i++) {
				min = Math.min(min, dp[k-coins.get(i)]+1);
			}
			dp[k]=min;
		}

		return dp[K]>=MAX? -1: dp[K];
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		Set<Integer> tset = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			tset.add(stoi(br.readLine()));
		}
		coins.clear();
		for (int c : tset)
			coins.add(c);

		Collections.sort(coins);
		coins.add(Integer.MAX_VALUE);
		System.out.println(solve());
	}
}
