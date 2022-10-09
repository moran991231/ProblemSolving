package done;

import java.io.*;
import java.util.*;

class Boj18248 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Bell implements Comparable<Bell>{
		boolean[] people;
		int cnt=0;
		Bell(int n){
			people = new boolean[n];
		}
		void heardBy(int p) {
			people[p]=true;
			cnt++;
		}
		
		@Override
		public int compareTo(Bell b) {
			return cnt-b.cnt;
		}
		
	}
	
	public static String HearingJeya(int N, int M, Bell[]bells) {
		for(int i=0; i<N;i++) {
			boolean heardFlag=false;
			for(int j=0; j<M;j++) {
				boolean aij = bells[j].people[i];
				if(heardFlag) {
					if(!aij)
						return "NO";
				}
				else
					heardFlag=aij;
			}
		}
		return "YES";
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		
		st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		Bell[] bells = new Bell[M];
		for(int i=0; i<M;i++)
			bells[i] = new Bell(N);
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				if(stoi(st.nextToken())==1)
					bells[j].heardBy(i);
			}
		}
		
		Arrays.sort(bells);
		System.out.println(HearingJeya(N,M,bells));
		
		

	}
}
