package done;


import java.io.*;
import java.util.*;

class Boj1418_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,K;
	static int[] primes;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

static void makePrime() {
	ArrayList<Integer> primeList = new ArrayList<>();
	primeList.add(2);
	for(int x=3; x<=100;x+=2) {
		boolean isPrime=true;
		for(int n :primeList) {
			if(x%n==0) {
				isPrime=false;
				break;
			}
		}
		if(isPrime)
			primeList.add(x);
	}
	
	primes = new int[primeList.size()];
	for(int i=0; i<primes.length;i++)
		primes[i] = primeList.get(i);
	
}
	public static void main(String[] args) throws IOException {
		if(primes==null)
			makePrime();
		
		N = stoi(br.readLine());
		K = stoi(br.readLine());
		
		int cnt=1;
		int psize = primes.length;
		for(int n=2;n<=N;n++) {
			if(n<=K) {
				cnt++;
				continue;
			}
			int num=n;
			for(int p:primes) {
				if(K<p)break;
				while(num%p==0)
					num/=p;
			}
			if(num==1) cnt++;
		}
		System.out.println(cnt);
		
	}
}
