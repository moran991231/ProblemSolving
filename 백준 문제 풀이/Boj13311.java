package done;

import java.io.*;
import java.util.*;

class Boj13311 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer> oddsList = null;
	static int[] odds;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void makeOdds() {
		oddsList = new ArrayList<>();
		oddsList.add(2);
		for(int i=3 ;i<=100000; i++) {
			boolean flag = true;
			for(int odd: oddsList) {
				if(i % odd == 0) {
					flag =false;
					break;
				}
			}
			if(flag) oddsList.add(i);
			
		}
//		for(int odd: oddsList) {
//			System.out.println(odd);
//		}
//		System.out.println(oddsList.size());
		
		
	}
	
	static int isK_sejoon(int n, int K) {
		int idx = Collections.binarySearch(oddsList, K);
		
		if(K<0) 
			idx = -idx-1;
		if( idx<oddsList.size())
			if(oddsList.get(idx)==K) idx++;
		for(; idx<oddsList.size() && oddsList.get(idx)<=n; idx++) {
			if(n%oddsList.get(idx) ==0)
				return 0;
		}
//		System.out.println(n);
		return 1;
		
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		if(oddsList == null) makeOdds();
		int N = stoi(br.readLine());
		int K = stoi(br.readLine());
		
		int cnt=1;
		for(int i=2; i<=N; i++) {
			if(i<=K) cnt++;
			else cnt += isK_sejoon(i,K);
				
			
		}
		System.out.println(cnt);
		
	}

}