package round5;

import java.io.*;
import java.util.*;

class Boj3985 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L,N;
	static ArrayList<Integer> cake = new ArrayList<>(1000);
	static int[][] guest;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static int divideCake() {
		int i1, i2;
		for(int i=0; i<N;i++) {
			if(cake.size()<=0)
				break;
			int[] g = guest[i];
			i1=Collections.binarySearch(cake, g[0]);
			i2 = Collections.binarySearch(cake, g[1]);
			if(i1<0) i1=  Math.min(~i1, cake.size()-1);
			if(i2<0) i2 = Math.min((~i2)-1,cake.size()-1);
			g[2]=i2-i1+1;
			for(int k=0; k<g[2];k++) {
				cake.remove(i1);
			}
			
		}
		int max=0, max_i=0;
		for(int i=0; i<N; i++) {
			if(guest[i][2]>max) {
				max = guest[i][2];
				max_i = i;
			}
		}
			
		return max_i+1;
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		cake.clear();
		L = stoi(br.readLine());
		N = stoi(br.readLine());
		guest = new int[N][3];
		for(int i=1; i<=L;i++)
			cake.add(i);
		
		int max=0, max_i=0;
		int p,k;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			guest[i][0] = p=stoi(st.nextToken());
			guest[i][1] =k= stoi(st.nextToken());
			if(k-p>max) {
				max=k-p;
				max_i	=i;
			}
		}
		max_i++;
		
		int ret = divideCake();
		System.out.printf("%d\n%d\n", max_i,ret);
		
		
		
		
		
		
	}

}
