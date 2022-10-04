package done;

import java.io.*;
import java.util.*;

class Boj_3273 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, x;
	static int[]A;
	
	static int upperBound(int s, int e, int target) {
		int p=-1;
		while(s<=e) {
			p = (s+e+1)/2;
			if(A[p]<=target) {
				if(s==p) break;
				s=p;
			}else e=p-1;
		}
		return p;
	}
	static int lowerBound(int s, int e, int target) {
		int p=-1;
		while(s<=e) {
			p = (s+e)/2;
			if(target<=A[p]) {
				if(p==e) break;
				e=p;
			}else s=p+1;
		}
		if(A[p]==target) return p;
		else return -1;
	}
	
	static int countPair() {
		int cnt=0;
		if(N==1) return cnt;
		int i=0, j=N-1;
		while(i<j) {
			if(x/2<A[i]) break;
			int l,r, target=x-A[i];
			l = lowerBound(i+1, N-1,target);
			if(l==-1) {
				i++; continue;
			}
			r = upperBound(l, N-1, target);
			if(target*2 == x) {
				cnt += (r-l+2)*(r-l+1)/2;
				i= r+1;
				continue;
			}
			cnt += r-l+1;
			i++;
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		System.out.print(countPair());
	}

}
