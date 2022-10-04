package done;

import java.util.*;

class Boj_11401 {
	static final long  MOD = 1000000007;

	static int C(int n, int k) {
		long numerator=1, denominator=1;
		for(int i=n; n-k+1<=i; i--)
			numerator  = (numerator * i)%MOD;
		for(int i=1; i<=k; i++)
			denominator = (denominator * i)%MOD;
		return (int)(numerator/denominator);
	}

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		sc.close();
		System.out.print(C(N,K));
	}

}
